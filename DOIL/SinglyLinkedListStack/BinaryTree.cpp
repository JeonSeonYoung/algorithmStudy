#include <stdio.h.>
#include <stdlib.h>
typedef struct _node {
	int data;
	struct _node *LeftChild= NULL;
	struct _node *RightChild = NULL;
}Node;

typedef struct _list {
	Node *Root =NULL;
	Node *SubRoot = NULL;
//	Node *Cur;
	//Node *ParentNode = NULL;
	int RootNumber;
}List;

//void PutNodeTree(int value);
void InitList();
void Preorder(Node* p);
void bSearchInsert(Node* p, int data);
void bContains(Node* p, int value);
void bGetParentData(Node* p, int value);
void DelSubTree(Node* p);
void bDelNode(Node* p, int value);


List *L = (List*)malloc(sizeof(List));
int main(void)
{
//	Node *Cur = (Node*)malloc(sizeof(Node));
//	Cur = L->Root;
	InitList();
	bSearchInsert(L->Root, 20);								//								20
	bSearchInsert(L->Root, 10);								//							10		30
	bSearchInsert(L->Root, 30);								//						 5	  15	  35
	bSearchInsert(L->Root, 5);								//							 12	
	bSearchInsert(L->Root, 15);								//
	bSearchInsert(L->Root, 12);								//
	bSearchInsert(L->Root, 35);								//

//	printf("%d ", L->Root->RightChild->data);
//	printf("%d ", L->Root->RightChild->RightChild->data);
	Preorder(L->Root);
	printf("\n");
	bContains(L->Root,15);
	printf("\n");
	
	bGetParentData(L->Root, 30);
	
	bDelNode(L->Root,15);
	printf("%d ", L->Root->data);
	printf("%d ", L->Root->LeftChild->data);
	printf("%d ", L->Root->LeftChild->LeftChild->data);
	printf("%d ", L->Root->RightChild->data);
	printf("%d ", L->Root->RightChild->RightChild->data);
	printf("%d ", L->Root->LeftChild->RightChild->data);
	printf("%d ", L->Root->LeftChild->RightChild->LeftChild->data);
	
	//Preorder(L->Root);
	free(L);
}
void InitList()
{
	L->Root = NULL;
	//L->PreNode = NULL;
	//L->Cur = NULL;
	//ParentNode = NULL;
	L->RootNumber = 0;
}
/*
void PutNodeTree(int value)
{
	Node* NewNode = (Node*)malloc(sizeof(Node));

	NewNode->data = value;
	NewNode->LeftChild = NULL;
	NewNode->RightChild = NULL;>

	++(L->RootNumber);

	if (L->RootNumber == 1) {
		L->Root = NewNode;
		L->ParentNode = L->PreNode = L->Root;
	}
	else {
		if (L->ParentNode == L->PreNode) {
			if (L->ParentNode->data >= value) L->ParentNode->LeftChild = NewNode;
			else L->ParentNode->RightChild = NewNode;
		}
		else {

		}
	}

}
*/
//이진탐색을 이용한 삽입

void bSearchInsert(Node* p, int value){
	Node* InitNode = (Node*)malloc(sizeof(Node));
	Node* NewNode = (Node*)malloc(sizeof(Node));
	NewNode->data = value;
	NewNode->LeftChild = NULL;
	NewNode->RightChild = NULL;

	++(L->RootNumber);
	
	if (L->RootNumber == 1) {
		L->Root = NewNode;
//		printf("%d ", L->Root->data);
	}
	else {
		if (p->data > value) {

			if (p->LeftChild == NULL) p->LeftChild = NewNode;

			else bSearchInsert(p->LeftChild, value);
		}

		else {
			if (p->RightChild == NULL) p->RightChild = NewNode;

			else bSearchInsert(p->RightChild, value);
		}

	}
}
void bContains(Node* p, int value) {	

	if (p->data == value) {
		printf("%d값이 존재합니다.\n", value);
		return;
	}
	if (p->data > value) {

		if (p->LeftChild == NULL) printf("%d값이 존재하지않습니다.\n", value);
		else bContains(p->LeftChild, value);
	}
	else{
	//if(p->data < value){
			if (p->RightChild == NULL) printf("%d값이 존재하지않습니다.\n", value);
			else bContains(p->RightChild, value);
	}
	
}

void bGetParentData(Node* p, int value) {

	if (p->LeftChild->data == value) {
		printf("%d\n", p->data);
		return;
	}
	if (p->RightChild->data == value) {
		printf("%d\n", p->data);
		return;
	}
	if (p->data > value) {

		if (p->LeftChild == NULL) printf("%d값이 존재하지않습니다.\n", value);
		else bGetParentData(p->LeftChild, value);
	}
	else {
		//if(p->data < value){
		if (p->RightChild == NULL) printf("%d값이 존재하지않습니다.\n", value);
		else bGetParentData(p->RightChild, value);
	}
	


}
void DelSubTree(Node* p)
{
	Node* pLeft;
	Node* pRight;
	if (p == NULL)
		return;
	else {
		pLeft = p->LeftChild;
		pRight = p->RightChild;
		free(p);
		--(L->RootNumber);
		DelSubTree(pLeft);
		DelSubTree(pRight);
	}

}

void bDelNode(Node* p, int value)
{
	Node*temp;
	if (p->data == value) {

		DelSubTree(p);

		return;
	}
	if (p->data > value) {

		if (p->LeftChild == NULL) printf("%d값이 존재하지않습니다.\n", value);
		else bDelNode(p->LeftChild, value);
	}
	else {
		//if(p->data < value){
		if (p->RightChild == NULL) printf("%d값이 존재하지않습니다.\n", value);
		else bDelNode(p->RightChild, value);
	}

}
void Preorder(Node* p ){

	if (p == NULL) return; 

	printf("%d ->", p->data); 

	Preorder(p->LeftChild); 

	Preorder(p->RightChild); 

}

