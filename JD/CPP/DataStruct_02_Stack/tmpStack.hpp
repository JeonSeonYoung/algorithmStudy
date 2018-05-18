#pragma once

template<typename T>
class CTmpStack
{
private:
	T ** m_pData;
	int m_iSize;
	int m_iPoint;//가장 최근에 추가한곳

public:
	CTmpStack(void):m_pData(NULL), m_iSize(0), m_iPoint(0) {}
	~CTmpStack(void) {
		ReleaseEnement();
	}
	CTmpStack(int _iSize)
	{
		m_pData = new T*[_iSize];
		memset(m_pData, NULL, sizeof(T*) * _iSize);
		m_iSize = _iSize;
		m_iPoint = -1;
	}

	bool Push(T _data)
	{
		if (m_iPoint + 1 < m_iSize)//내가 추가하려는 곳이 할당된 공간 안 인가?
			++m_iPoint;
		else
			return false;
		T* data = new T;
		*data = _data;
		m_pData[m_iPoint] = data;
		return true;
	}
	bool Pop()
	{
		if (IsInRange(m_iPoint))
		{
			Release(&m_pData[m_iPoint]);
			--m_iPoint;
			return true;
		}
		return false;
	}
	T Peek()
	{
		if (IsInRange(m_iPoint))
			return *m_pData[m_iPoint];
		else
			return NULL;
	}
	T PeekPoint(int _iPoint)
	{
		if (IsInRange(_iPoint))
			if (m_pData[_iPoint] == NULL)
				return NULL;
			return *(m_pData[_iPoint]);
	}
	int Size()
	{
		return m_iSize;
	}
	void Clear()
	{
		ReleaseEnement();
	}
	bool IsEmpty()
	{
		if (m_iPoint == -1)
			return true;
		else
			return false;
	}
	bool IsFull()
	{
		if ((m_iPoint + 1) == m_iSize)
			return true;
		else
			return false;
	}
	bool IsInRange(int _iPoint)
	{
		if (_iPoint >= 0 && _iPoint < m_iSize)
			return true;
		else
			return false;
	}

	void ReleaseEnement()
	{
		for (int i = 0; i < m_iSize; ++i)
		{
			//if (m_pData[i] != NULL)
			Release(&m_pData[i]);
		}
		m_iPoint = -1;
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