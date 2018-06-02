#include <stdlib.h>
#include <iostream>

using namespace std;

struct node{
	int iNum;
	node *nNext;
};

struct hNode{
	node *nDock;
};

void InitList(hNode *&hHead)
{
	hHead=(hNode *)malloc(sizeof(hNode));
	hHead -> nDock = NULL;
}

void Push(hNode *nTop, int iNewNum)
{
	node *nTemp;
	nTemp = (node *)malloc(sizeof(node));
	nTemp -> iNum = iNewNum;
	nTemp -> nNext = nTop -> nDock;
	nTop -> nDock = nTemp;
	
}

bool Pop(hNode *nTop)
{
	node *nDel;
	nDel = nTop->nDock;
	if (nDel==NULL) {
		return false;
	}
	nTop->nDock=nDel->nNext;
	free(nDel);
	return true;
}

void EnQueue(hNode *Front,hNode *Rear, int iNewNum)		//포인터를 반환하기위해서는 포인터 함수를 사용해야만 함.
{
	node *New;
		New=(node *)malloc(sizeof(node));
		New->iNum = iNewNum;

	if(Front->nDock == NULL)
	{
		New->nNext = Front ->nDock;
		Front->nDock = New;
	//	Rear->nDock = New;
	}
	else
	{
		New->nNext=Rear->nDock->nNext;
		Rear->nDock->nNext = New;
	//	Rear->nDock = New;
	}
	Rear->nDock = New;
}

bool DeQueue(hNode *nTop)
{
	node *nDel;
	nDel = nTop->nDock;
	if (nDel==NULL) {
		return false;
	}
	nTop->nDock=nDel->nNext;
	free(nDel);
	return true;
}
void SortStack(hNode *&hHead)
{
	node *nNew;
	node *nSort;
	nNew = hHead->nDock;

	//두번째 노드가 없을경우 비교하지 않는다.
	if(hHead->nDock->nNext == NULL)
	{}

	//새로 삽입된 노드가 두번째 노드보다 값이 클경우는 이동할 필요가 없으므로 생략!
	else if(hHead->nDock->iNum < hHead->nDock->nNext->iNum)
	{
		//새로 삽입한 노드의 숫자가 List에 저장되어 있는 숫자보다 클때까지 순차적으로 검사 이동한다.
		//비교하는 값이 nSort->nNext->iNum인 이유는 
		//nSort->nNext(검색노드 전 노드)와 nSort->nNext->nNext(검색노드) 의 값 모두 필요하기 때문 입니다.
		for(nSort=nNew; nNew->iNum < nSort->nNext->iNum; nSort=nSort->nNext)
		{
			//만약 검색하는 노드의 다음주소가 비어있을 경우 검색 종료
			if(nSort->nNext->nNext==NULL)
				break;
		}
		//검색한 노드의 다음노드가 없고 검색한 노드의 값이 삽입한 값보다 작을경우
		if(nSort->nNext->nNext==NULL && nSort->nNext->iNum < nNew->iNum)
		{
			hHead->nDock=nNew->nNext;
			nNew->nNext=nSort->nNext;
			nSort->nNext=nNew;
			//(이전노드) ^^^^ (검색노드)  (NULL)
			//		  (삽입노드)
		}
		//검색한 노드의 다음노드가 없고 검색한 노드의 값이 삽입한 값보다 클경우
		else if(nSort->nNext->nNext==NULL)
		{
			hHead->nDock=nNew->nNext;
		//	cout << nNew->iNum << endl;
		//	cout << nNew->nNext << endl;
		//	cout << nSort->nNext->nNext;
			system("pause");
		//	nNew->nNext=nSort->nNext->nNext; // 뜻이 nNew->nNext=NULL인데 왜 안될까?
			nSort->nNext->nNext=nNew;
			nNew->nNext=NULL;
			//(이전노드) (검색노드) ^^^^  (NULL)
			//			         (삽입노드)
		}
		//노드 중간에 삽입될 경우
		else
		{
			hHead->nDock=nNew->nNext;
			nNew->nNext=nSort->nNext;
			nSort->nNext=nNew;
		}
	}
	//정렬 끝!!
}
/*
Node *SortQ(Node **head,Node **Rear,Node **NewRe)
{
	Node *newNo;
	Node *nSort;
	Node *ReTu;
	newNo=(*NewRe);
	nSort=(*head);
	//두번째 노드가 없거나 마지막 노드보다 새 노드가 클경우 비교하지 않는다.
	if((*head)->next->next == NULL || newNo->num > (*Rear)->num)
	{
// 이동하지 않을경우 새로 삽입된 노드가 Rear가 된다.
		ReTu = (*NewRe);
	}
//새로 삽입된 노드가 노드에 있는 값보다 클경우는 이동할 필요가 없으므로 생략!
	else if(newNo->num <= (*Rear)->num)//새로 삽입된 노드가 값이 작을경우
	{
		//새로 삽입한 노드의 숫자가 저장되어 있는 숫자보다 클 경우 다음노드로 이동
		for(nSort=(*head); newNo->num > nSort->next->num; nSort=nSort->next)
		{}
// 노드 이동 알고리즘 (새 노드값보다 큰 노드를 찾아 찾은 노드 앞에 삽입하는 기능)
		newNo->next=nSort->next;
		nSort->next=newNo;
		(*Rear)->next=NULL;
// 이동하였을 경우 새 노드를 가리키는 노드가 Rear가 된다.
		ReTu = (*Rear);
	}
// 확인시 주석제거! ㅋㅋ
//	Printing(*head);
	return ReTu;
}
*/



void Printing(hNode *head)
{
	node *Start;
	for (Start=head->nDock;Start;Start=Start->nNext) {
		cout << "|"<< Start -> iNum <<"|"<<endl;
	}
	cout << "---" << endl;
	printf("\n");
}

