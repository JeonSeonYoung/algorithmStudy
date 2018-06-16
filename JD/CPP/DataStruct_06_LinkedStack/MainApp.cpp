#include"MainApp.h"

int main()
{
	CTmpStack_List<int>* m_pTmpList = new CTmpStack_List<int>;

	m_pTmpList->Push(100);

	m_pTmpList->Push(232);

	m_pTmpList->Push(500);

	m_pTmpList->PrintList();

	m_pTmpList->Pop();

	m_pTmpList->PrintList();

	m_pTmpList->Pop();

	m_pTmpList->PrintList();

	m_pTmpList->Push(100);

	m_pTmpList->Push(232);

	m_pTmpList->Push(500);

	m_pTmpList->Push(100);

	m_pTmpList->Push(232);

	m_pTmpList->Push(500);

	m_pTmpList->PrintList();

	int iPeekIdx = 2;
	cout << "////////////////////" << endl;
	cout << "Peek(" << iPeekIdx <<") : " << m_pTmpList->Peek(iPeekIdx) << endl;
	cout << "////////////////////" << endl;

	m_pTmpList->Clear();

	m_pTmpList->PrintList();

	delete m_pTmpList;

	return 0;

}
void List_TestCode()
{
	CTmpList<int>* pTmpList = new CTmpList<int>;

	pTmpList->Add_First(10);
	cout << "Get (0) : ";
	cout << pTmpList->Get(0) << endl;
	pTmpList->Add_First(20);
	cout << "Get (0) : ";
	cout << pTmpList->Get(0) << endl;
	cout << "Get (1) : ";
	cout << pTmpList->Get(1) << endl;

	pTmpList->Remove_Last();
	cout << "Get (0) : ";
	cout << pTmpList->Get(0) << endl;
	cout << "Get (1) : ";
	cout << pTmpList->Get(1) << endl;

	cout << "contains(10) : ";
	cout << pTmpList->Contains(10) << endl;
	cout << "contains(20) : ";
	cout << pTmpList->Contains(20) << endl;

	pTmpList->Add_First(8);
	pTmpList->Add_First(1);
	pTmpList->Add_First(40);
	pTmpList->PrintList();

	pTmpList->Add_Last(55);
	pTmpList->Add_Last(66);
	pTmpList->Add_Last(77);
	pTmpList->PrintList();

	pTmpList->Clear();
	pTmpList->PrintList();

	pTmpList->Add_Last(55);
	pTmpList->Add_Last(66);
	pTmpList->Add_Last(77);
	pTmpList->PrintList();

	pTmpList->Add_First(8);
	pTmpList->Add_First(1);
	pTmpList->Add_First(40);
	pTmpList->PrintList();
	pTmpList->Add_Last(88);
	pTmpList->Add_Last(99);
	pTmpList->PrintList();

	delete pTmpList;
}
void DualList_TestCode()
{
	CTmpDualList<int>* pTmpList = new CTmpDualList<int>;

	pTmpList->Add_First(10);
	cout << "Get (0) : ";
	cout << pTmpList->Get(0) << endl;
	pTmpList->Add_First(20);
	cout << "Get (0) : ";
	cout << pTmpList->Get(0) << endl;
	cout << "Get (1) : ";
	cout << pTmpList->Get(1) << endl;

	pTmpList->Remove_Last();
	cout << "Get (0) : ";
	cout << pTmpList->Get(0) << endl;
	cout << "Get (1) : ";
	cout << pTmpList->Get(1) << endl;

	cout << "contains(10) : ";
	cout << pTmpList->Contains(10) << endl;
	cout << "contains(20) : ";
	cout << pTmpList->Contains(20) << endl;

	pTmpList->Add_First(8);
	pTmpList->Add_First(1);
	pTmpList->Add_First(40);
	pTmpList->PrintList();

	pTmpList->Add_Last(55);
	pTmpList->Add_Last(66);
	pTmpList->Add_Last(77);
	pTmpList->PrintList();

	pTmpList->Clear();
	pTmpList->PrintList();

	pTmpList->Add_Last(55);
	pTmpList->Add_Last(66);
	pTmpList->Add_Last(77);
	pTmpList->PrintList();

	pTmpList->Add_First(8);
	pTmpList->Add_First(1);
	pTmpList->Add_First(40);
	pTmpList->PrintList();
	pTmpList->Add_Last(88);
	pTmpList->Add_Last(99);
	pTmpList->PrintList();

	delete pTmpList;
}