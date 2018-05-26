#include "StdAfx.h"
#include "tmpStack.hpp"
#include "tmpQueue.hpp"
#include "tmpQueue_Circle.hpp.hpp"

void main()
{
	
		


	
}

void StackSample()
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

	CTmpStack <char> *m_pStack_Mid = new CTmpStack <char>(20);//할당
	CTmpStack <char> *m_pStack_Back = new CTmpStack <char>(20);//할당
	CTmpStack <char> *m_pStack_Operator = new CTmpStack <char>(20);//할당


	m_pStack_Mid->Push('1');
	m_pStack_Mid->Push('+');
	m_pStack_Mid->Push('2');
	m_pStack_Mid->Push('-');
	m_pStack_Mid->Push('3');
	m_pStack_Mid->Push('*');
	m_pStack_Mid->Push('4');

	int valueCnt = 0;
	int operaterCnt = 0;

	int max = m_pStack_Mid->Size();
	for (int i = 0; i < max; ++i)
	{
		if (m_pStack_Mid->Peek() > 47 && m_pStack_Mid->Peek() < 58)
		{
			m_pStack_Back->Push(m_pStack_Mid->Peek());
			++valueCnt;
		}
		else
		{
			m_pStack_Operator->Push(m_pStack_Mid->Peek());
			++operaterCnt;
		}

		if (valueCnt == 2 && operaterCnt == 1)
		{
			valueCnt = 1; operaterCnt = 0;
			m_pStack_Back->Push(m_pStack_Operator->Peek());
			m_pStack_Operator->Pop();
		}

		m_pStack_Mid->Pop();
	}


	int iAllSize = m_pStack_Back->Size();

	cout << "operater : //////////////////////////////" << endl;
	for (int i = 0; i < iAllSize; ++i)
		cout << m_pStack_Back->PeekPoint(i) << endl;
}