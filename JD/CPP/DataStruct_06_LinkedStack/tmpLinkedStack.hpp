#pragma once
#include "tmpStruct.hpp"

template < typename T>
class CTmpStack_List
{
private:
	int m_iSize;
	Node<T>* m_pHead;

public:
	CTmpStack_List(void) :m_iSize(0), m_pHead(NULL) {}
	~CTmpStack_List(void) { Clear(); }

	void Push(T _value)
	{
		Node<T>* pNode = new Node<T>;
		pNode->value = _value;
		pNode->pNext = NULL;

		if (m_pHead != NULL)
			pNode->pNext = m_pHead;

		m_pHead = pNode;
		++m_iSize;
	}
	bool Pop()
	{
		Node<T>* pPoint = m_pHead;
		if (pPoint == NULL)
			return false;
		if (pPoint->pNext == NULL)
		{
			delete pPoint;
			m_pHead = NULL;
		}
		else
		{
			m_pHead = pPoint->pNext;
			delete pPoint;
		}
		--m_iSize;
		return true;
	}
		
	T Peek(int index)
	{
		Node<T>* pPoint = m_pHead;

		int i = 0;

		while (pPoint != NULL)
		{
			if (i == index)
			{
				return pPoint->value;
			}
			
			pPoint = pPoint->pNext;
			++i;
		}
		
		return -1;
	}

	bool Contains(T value)
	{
		Node<T>* pPoint = m_pHead;

		while (pPoint != NULL)
		{
			if (pPoint->value == value)
				return true;
			
			pPoint = pPoint->pNext;
		}
		return false;
	}
	int Size()
	{
		return m_iSize;
	}
	bool IsEmpty()
	{
		if (m_pHead == NULL)
			return true;
		else false;
	}
	void Clear()
	{
		while (true)
			if (!Pop())
				break;
	}
	void PrintList()
	{
		cout << "\nSize : " << m_iSize << endl;

		for (int i = 0; i < m_iSize; ++i)
		{
			cout << "Element(" << i << ") : ";
			cout << Peek(i) << endl;
		}
	}
};