#pragma once

template<typename T>
class CTmpQueue_Circle
{
private:
	T * * m_pData;
	int m_iSize;
	int m_iHead;//머리
	int m_iTail;//꼬리

public:
	CTmpQueue_Circle(void) :m_pData(NULL), m_iSize(0), m_iHead(0), m_iTail(0) {}
	~CTmpQueue_Circle(void) {
		ReleaseEnement();
	}
	CTmpQueue_Circle(int _iSize)
	{
		m_pData = new T*[_iSize];
		memset(m_pData, NULL, sizeof(T*) * _iSize);
		m_iSize = _iSize;
		m_iHead = 0;
		m_iTail = 0;
	}

	void EnQueue(T _data)
	{
		if (m_pData[m_iHead] != NULL)//큐가 비어있는지 검사
			return;

		T* data = new T;
		*data = _data;
		m_pData[m_iHead] = data;

		++m_iHead;
		if (m_iHead == m_iSize)
			m_iHead = 0;
	}

	void DeQueue()
	{
		if (m_pData[m_iTail] == NULL)
			return;

		Release(&m_pData[m_iTail]);
		++m_iTail;
		if (m_iTail == m_iSize)
			m_iTail = 0;
	}

	T Peek()
	{
		if (m_pData[m_iTail] == NULL)
			return NULL;
		return *m_pData[m_iTail];
	}

	bool IsFull()
	{
		bool isFull = (m_iHead == m_iTail && m_pData[m_iHead] != NULL);

		return isFull;
	}
	bool IsEmpty()
	{
		bool isEmpty = (m_iHead == m_iTail && m_pData[m_iHead] == NULL);

		return isEmpty;
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
		m_iHead = 0;
		m_iTail = 0;
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