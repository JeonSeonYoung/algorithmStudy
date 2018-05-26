#pragma once

template<typename T>
class CTmpQueue
{
private:
	T * * m_pData;
	int m_iSize;
	int m_iHead;//¸Ó¸®
	int m_iTail;//²¿¸®

public:
	CTmpQueue(void) :m_pData(NULL), m_iSize(0), m_iHead(0), m_iTail(0) {}
	~CTmpQueue(void) {
		ReleaseEnement();
	}
	CTmpQueue(int _iSize)
	{
		m_pData = new T*[_iSize];
		memset(m_pData, NULL, sizeof(T*) * _iSize);
		m_iSize = _iSize;
		m_iHead = _iSize -1;
		m_iTail = _iSize - 1;
	}

	void EnQueue(T _data)
	{
		T* data = new T;
		*data = _data;
		m_pData[m_iHead] = data;

		if (m_iHead - 1 < 0)
			return;
		--m_iHead;
	}

	void DeQueue()
	{
		if (m_pData[m_iTail] == NULL)
			return;

		Release(&m_pData[m_iTail]);
		++m_iHead;
		for (int i = m_iTail; i > m_iHead; --i)
		{
			m_pData[i] = m_pData[i - 1];
		}
		m_pData[m_iHead] = NULL;
	}

	T Peek()
	{
		if (m_pData[m_iTail] == NULL)
			return NULL;
		return *m_pData[m_iTail];
	}
	
	bool IsFull()
	{
		if (m_pData[0] != NULL)
			return true;
		else
			return false;
	}
	bool IsEmpty()
	{
		if (m_iHead == m_iTail)
			return true;
		else
			return false;
	}

	int Size()
	{
		return m_iSize;
	}
	void Clear()
	{
		ReleaseEnement();
	}

	void ReleaseEnement()
	{
		for (int i = 0; i < m_iSize; ++i)
		{
			//if (m_pData[i] != NULL)
			Release(&m_pData[i]);
		}
		m_iHead = m_iSize - 1;
		m_iTail = m_iSize - 1;
	}

	template < typename TT>
	bool Release(TT** _p)
	{
		if (*_p != NULL)
		{
			delete *_p;
			*_p = NULL;
			return true;
		}
		return false;
	}
};