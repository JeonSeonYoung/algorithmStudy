#include "StdAfx.h"
#include "tmpArr.h"


void main()
{
	//스택 메모리와 힙 메모리중 힙이 더 빠르다

	//stack memory
	CTmpArr <int> m_arr_1(3);	

	m_arr_1.SetData(1, 10);

	cout << m_arr_1.GetData(1) << endl;
	cout << m_arr_1.Size() << endl;

	//heap memory
	CTmpArr <int> *m_pArr = new CTmpArr <int>(2);//할당

//	m_pArr->SetData(1, 100);
//	cout << m_pArr->GetData(1) << endl;
	for (int i = 0; i < 5; ++i)
		m_pArr->Add(i);

	for (int i = 0; i < m_pArr->Size(); ++i)
		cout << m_pArr->GetData(i) << endl;

	cout << "------------------------------------" << endl;

	for (int i = 0; i < 5; ++i)
		m_pArr->Add(10, 10);

	for (int i = 0; i < m_pArr->Size(); ++i)
		cout << m_pArr->GetData(i) << endl;

	delete m_pArr;//해제
}