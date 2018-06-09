#include "myList.h"




void main()
{
	///// 변수선언부
	hNode *hStackHead;
	hNode *hQueueHead;
	hNode *hQueueTail;

	char cChoice;
	int iNum;

	///// 메모리 할당
	InitList(hStackHead);
	InitList(hQueueHead);
	InitList(hQueueTail);

	while(true)
	{
	//	system("cls");

		cout << "1. 푸시 출력"<<endl;
		cout << "2. 팝 "<<endl;
		cout << "3. 인큐 "<<endl;
		cout << "4. 디큐 "<<endl;
		cout << "5. 스택 출력 "<<endl;
		cout << "6. 큐 출력 "<<endl;
		cout << "0. 종료 "<<endl;
		cout << "선택해라 : ";
		cin >> cChoice;
		switch(cChoice)
		{
		case '1':
			cout << "얼마넣을겨 "<<endl;
			cin >> iNum;
			Push(hStackHead,iNum);
			Printing(hStackHead);
			SortStack(hStackHead);
			Printing(hStackHead);
		//	system("pause");
			break;

		case '2':
			Pop(hStackHead);
			break;

		case '3':
			cout << "얼마넣을겨 "<<endl;
			cin >> iNum;
			EnQueue(hQueueHead,hQueueTail,iNum);
			
			break;

		case '4':
			DeQueue(hQueueHead);
			break;

		case '5':
			Printing(hStackHead);
			system("pause");
			break;

		case '6':
			Printing(hQueueHead);
			system("pause");
			break;

		case '0':
			cout << "종료를 선택하셨습니다." << endl;
			return;

		default :
			cout << "잘못 선택하셨습니다." << endl;
			system("pause");
		}

	}

	





}
