#pragma once
#include "tmpStruct.hpp"

template < typename T>
class CTmpDualList
{
private:
	int m_iSize;
	Node_Dual<T>* m_pHead;
	Node_Dual<T>* m_pTail;

public:
	CTmpDualList(void) :m_iSize(0), m_pHead(NULL), m_pTail(NULL) {}
	~CTmpDualList(void) { Clear(); }

	

	void Add_First(T _value)
	{
		Node_Dual<T>* pNode = new Node_Dual<T>;
		pNode->value = _value;
		pNode->pNext = NULL;
		pNode->pPrev = NULL;

		if (m_pHead != NULL)//추가되는 노드에 Head포인터가 가리키고 있는 있는 노드의 있는 정보를 넣는 부분
		{
			pNode->pNext = m_pHead;
			m_pHead->pPrev = pNode;
		}
		m_pHead = pNode; //가장 앞에 있는 노드에 Head포인터를 이동시켜줌.

		if (m_pHead->pNext == NULL)
			m_pTail = pNode;
		++m_iSize;
	}
	void Add_Last(T _value)
	{
		if (m_pTail == NULL)
		{
			Add_First(_value);
			return;
		}
		Node_Dual<T>* pNode = new Node_Dual<T>;
		pNode->value = _value;
		pNode->pNext = NULL;
		pNode->pPrev = NULL;

		m_pTail->pNext = pNode;
		pNode->pPrev = m_pTail;
		m_pTail = pNode;

		++m_iSize;
	}

	void Add(int idx, T _value)
	{
		if (idx < 0)
			return;
		if (idx > m_iSize)
			return;
		if (idx == 0)
			Add_First(_value);
		else
		{
			if (idx == m_iSize)
				Add_Last(_value);
			else
			{
				int i = 0;
				Node_Dual<T>* pPoint = m_pHead;
				for (int i = 0; i < m_iSize; ++i)
				{
					if (pPoint == NULL)
						break;
					if (i == idx)
					{
						Node_Dual<T>* pNode = new Node_Dual<T>;
						pNode->value = _value;
						pNode->pNext = NULL;
						pNode->pPrev = NULL;

						pPoint->pPrev->pNext = pNode;//1. 포인트 이전 노드의 Next를 새로 만든 객체로 설정하고
						pNode->pPrev = pPoint->pPrev;//2. 새로만든 노드의 prev를 설정해준다
						pPoint->pPrev = pNode;//포인트의 Prev를 새로 만든 객체로 설정한다
						pNode->pNext = pPoint;//새로만든 노드의 Next를 pPoint로 설정한다.

						++m_iSize;
						break;
					}
					pPoint = pPoint->pNext;
				}
			}
		}
	}

	bool Remove_First()
	{
		Node_Dual<T>* pPoint = m_pHead;
		if (pPoint == NULL)
			return false;
		if (pPoint->pNext == NULL)
		{
			delete pPoint;
			m_pHead = NULL;
			m_pTail = NULL;
		}
		else
		{
			m_pHead = pPoint->pNext;
			m_pHead->pPrev = NULL;
			delete pPoint;
		}
		--m_iSize;
		return true;
	}
	
	void Remove_Last()
	{
		Node_Dual<T>* pPoint = m_pTail;
		if (pPoint == NULL)
			return;
		if (pPoint->pPrev == NULL)
		{
			delete pPoint;
			m_pHead = NULL;
			m_pTail = NULL;
		}
		else
		{
			m_pTail = pPoint->pPrev;
			m_pTail->pNext = NULL;
			delete pPoint;
		}
		--m_iSize;
	}
	
	void Remove(int idx)
	{
		if (idx < 0)
			return;
		if (idx >= m_iSize)
			return;
		if (idx == 0)
			Remove_First();
		else
		{
			if (idx == (m_iSize - 1))
				Remove_Last();
			else
			{
				Node_Dual<T>* pPoint = m_pHead;
				for (int i = 0; i < m_iSize; ++i)
				{
					if (pPoint == NULL)
						return;
					if (i == idx)
					{
						pPoint->pPrev->pNext = pPoint->pNext;
						pPoint->pNext->pPrev = pPoint->pPrev;
						delete pPoint;
						--m_iSize;
						break;
					}
					pPoint = pPoint->pNext;
				}
			}
		}

		
	}

	T Get(int index)
	{
		Node_Dual<T>* pPoint = m_pHead;

		int i = 0;

		while (true)
		{
			if (i == index)
			{
				if (pPoint != NULL)
					return pPoint->value;
				else
					return -1;
			}
			if (pPoint->pNext == NULL)
				return -1;

			pPoint = pPoint->pNext;
			++i;
		}
	}

	bool Contains(T value)
	{
		Node_Dual<T>* pPoint = m_pHead;

		while (true)
		{
			if (pPoint->value == value)
				return true;

			if (pPoint->pNext == NULL)
				break;
			pPoint = pPoint->pNext;
		}
		return false;
	}
	int Size()
	{
		return m_iSize;
	}
	void Clear()
	{
		while (true)
			if (!Remove_First())
				break;
	}
	bool IsEmpty()
	{
		if (m_pHead == NULL && m_pTail == NULL)
			return true;
		return false;
	}
	void PrintList()
	{
		cout << "\nSize : " << m_iSize << endl;

		for (int i = 0; i < m_iSize; ++i)
		{
			cout << "Element(" << i << ") : ";
			cout << Get(i) << endl;
		}
	}
};