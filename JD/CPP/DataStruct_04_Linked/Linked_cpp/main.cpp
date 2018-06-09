#include "StdAfx.h"
#include "tmpLinked.hpp"

int main()
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

	return 0;

}