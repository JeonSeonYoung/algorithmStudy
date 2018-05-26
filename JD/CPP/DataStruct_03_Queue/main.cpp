#include "StdAfx.h"
#include "tmpArr.hpp"
#include "tmpStack.hpp"
#include "tmpQueue.hpp"
#include "tmpQueue_Circle.hpp"

void main()
{
	CTmpQueue_Circle <int> *m_pQueue = new CTmpQueue_Circle <int>(10);//할당

	m_pQueue->EnQueue(10);
	cout << m_pQueue->Peek() << endl;
	m_pQueue->EnQueue(5);
	cout << m_pQueue->Peek() << endl;
	m_pQueue->DeQueue();
	cout << m_pQueue->Peek() << endl;
	m_pQueue->DeQueue();
	cout << m_pQueue->Peek() << endl;
	m_pQueue->DeQueue();
	cout << m_pQueue->Peek() << endl;


	delete m_pQueue;//해제
}
void TmpQueueSample()
{
	CTmpQueue <int> *m_pQueue = new CTmpQueue <int>(10);//할당

	m_pQueue->EnQueue(10);
	cout << m_pQueue->Peek() << endl;
	m_pQueue->EnQueue(5);
	cout << m_pQueue->Peek() << endl;
	m_pQueue->DeQueue();
	cout << m_pQueue->Peek() << endl;
	m_pQueue->DeQueue();
	cout << m_pQueue->Peek() << endl;
	m_pQueue->DeQueue();
	cout << m_pQueue->Peek() << endl;


	delete m_pQueue;//해제
}
void TmpStackSample()
{
	//heap memory
	CTmpStack <int> *m_pStack = new CTmpStack <int>(10);//할당

	int iSize = m_pStack->Size();


	cout << "Push : //////////////////////////////" << endl;
	for (int i = 0; i < iSize + 2; ++i)
		if (m_pStack->Push(i))
		{
			cout << "Peek : ";
			cout << m_pStack->Peek() << endl;
		}
		else
		{
			cout << "OverFlow" << endl;
		}
	cout << "IsFull? : ";
	cout << m_pStack->IsFull() << endl;
	cout << "IsEmpty? : ";
	cout << m_pStack->IsEmpty() << endl;

	cout << endl;
	cout << "Stack 원소 확인 : //////////////////////////////" << endl;

	for (int i = 0; i < iSize; ++i)
	{
		cout << "PeepPoint : ";
		cout << m_pStack->PeekPoint(i) << endl;
	}

	cout << endl;
	cout << "Pop : //////////////////////////////" << endl;

	for (int i = 0; i < iSize + 2; ++i)
	{
		cout << "Peek : ";
		cout << m_pStack->Peek() << endl;
		m_pStack->Pop();
	}
	cout << "IsFull? : ";
	cout << m_pStack->IsFull() << endl;
	cout << "IsEmpty? : ";
	cout << m_pStack->IsEmpty() << endl;

	delete m_pStack;//해제
}