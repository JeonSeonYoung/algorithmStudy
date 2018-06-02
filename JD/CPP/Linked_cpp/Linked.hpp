#pragma once

template < typename T>
struct Node {
	T value;
	Node *pNext;
};

template < typename T>
class CList
{
private:
	int m_iSize;
	Node<T>* m_pHead;
	Node<T>* m_pTail;

public:
	CList(void) :m_iSize(0), m_pHead(NULL), m_pTail(NULL) {}
	~CList(void) {
	}

	void Add(T _value)
	{
		Node<T>* pNode = new Node<T>;
		pNode->value = _value;
		pNode->pNext = NULL;

		if (m_pHead->pNext != NULL)
			pNode->pNext = m_pHead;

		m_pHead = pNode;
		++m_iSize;
	}

	void Remove()
	{
		Node<T>* pPoint = m_pHead;
		if (pPoint == NULL)
			return;
		if (pPoint->pNext == NULL)
		{
			delete pPoint;
			m_pHead = null;
			return;
		}
		while (true)
		{
			if (pPoint->pNext->pNext == NULL)
			{
				delete pPoint->pNext;
				pPoint->pNext = NULL;
				break;
			}
			else
			{
				pPoint = pPoint->pNext;
			}
		}
		--m_iSize;
	}

	T Get(int index)
	{
		Node<T>* pPoint = m_pHead;
		
		for (int i = 0; i <= index; ++i)
		{
			if (i == index)
				return pPoint->value;
			pPoint = pPoint->pNext;
		}
		return NULL;
	}

	bool Contains(T value)
	{
		Node<T>* pPoint = m_pHead;

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
};