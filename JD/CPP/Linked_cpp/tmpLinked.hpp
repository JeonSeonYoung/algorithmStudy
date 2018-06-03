#pragma once

template < typename T>
struct Node {
	T value;
	Node *pNext;
};

template < typename T>
class CTmpList
{
private:
	int m_iSize;
	Node<T>* m_pHead;
	Node<T>* m_pTail;

public:
	CTmpList(void) :m_iSize(0), m_pHead(NULL), m_pTail(NULL) {}
	~CTmpList(void) { Clear(); }

	void Add_First(T _value)
	{
		Node<T>* pNode = new Node<T>;
		pNode->value = _value;
		pNode->pNext = NULL;

		if (m_pHead != NULL)
			pNode->pNext = m_pHead;

		m_pHead = pNode;
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
		Node<T>* pNode = new Node<T>;
		pNode->value = _value;
		pNode->pNext = NULL;
		
		m_pTail->pNext = pNode;
		m_pTail = pNode;

		++m_iSize;
	}
	bool Remove_First()
	{
		Node<T>* pPoint = m_pHead;
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
			delete pPoint;
		}
		--m_iSize;
		return true;
	}

	///<summary>
	//tail은 어짜피 역참조가 되지 않기 때문에 Add_Last 할때 빼곤 사실상 별로 쓸모가 없다
	///</summary>
	void Remove_Last()
	{
		Node<T>* pPoint = m_pHead;
		if (pPoint == NULL)
			return;
		if (pPoint->pNext == NULL)
		{
			delete pPoint;
			m_pHead = NULL;
			m_pTail = NULL;
			return;
		}
		while (true)
		{
			if (pPoint->pNext->pNext == NULL)
			{
				delete pPoint->pNext;
				pPoint->pNext = NULL;
				m_pTail = pPoint;
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
	void Clear()
	{
		while (true)
			if (!Remove_First())
				break;
	}
	void PrintList()
	{
		cout<<"\nSize : "<< m_iSize << endl;

		for (int i = 0; i < m_iSize; ++i)
		{
			cout << "Element(" << i << ") : ";
			cout << Get(i) << endl;
		}
	}
};