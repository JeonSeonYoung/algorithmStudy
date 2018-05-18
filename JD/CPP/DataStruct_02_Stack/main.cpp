#include "StdAfx.h"
#include "tmpStack.h"


void main()
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