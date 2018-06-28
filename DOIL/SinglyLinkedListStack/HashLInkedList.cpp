#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#define MOD 11

typedef struct NODE {
	int data;
	struct NODE* next;
}node;

typedef struct _list {
	node* head;
	node* cur;
	node* tail;
	int size;
}list;

list*L[MOD];
int hashvalue;

void InitLinkedList(list **L);
int HashFunction(int);
void Put(list **L, int hashvalue, int key);
bool Contains(list **L, int key);
void Deque(list **L, int key);
void RemoveKey(list **L, int key);
int CollisionMaxCount(list **L);
void Print(list** L);
int main(void)
{
	int ReceiveKey;
	int i;
	int choice = 0;
	int MaxCount;
	int key;
	bool Contain = false;
	srand(time(NULL));
	ReceiveKey = 50;

	InitLinkedList(L);
	for (i = 0; i < ReceiveKey; i++) {
		key = rand();
		hashvalue = HashFunction(key);
		Put(L, hashvalue, key);
	}
	Print(L);
	printf("\n");
	RemoveKey(L, 4);
	Print(L);
	printf("\n");
	MaxCount = CollisionMaxCount(L);
	printf("최대 충돌 갯수는 %d입니다.\n\n\n\n\n\n", MaxCount);

	printf("key값 함유여부 확인:");
	Contain = Contains(L, 5);

	(Contain) ? printf("key값이 존재합니다.\n") : printf("key값이 존재하지않습니다.\n");
	free(L);
	return 0;
}

void InitLinkedList(list **L)
{
	int i;

	for (i = 0; i < MOD; i++) {
		L[i] = (list*)malloc(sizeof(list));
		L[i]->head = NULL;
		L[i]->tail = NULL;
		L[i]->size = 0;
	}

}

int HashFunction(int key)
{
	return key % MOD;
}

void Put(list** L, int hashvalue, int key)
{
	node* New = (node*)malloc(sizeof(node));
	New->data = key;


	if (L[hashvalue]->head == NULL && L[hashvalue]->tail == NULL) {
		New->next = NULL;
		L[hashvalue]->head = New;
		L[hashvalue]->tail = New;
	}
	else if (L[hashvalue]->head == L[hashvalue]->tail) {
		L[hashvalue]->head->next = New;
		New->next = NULL;
		L[hashvalue]->tail = New;
		New->next = NULL;
	}
	else {
		L[hashvalue]->tail->next = New;
		New->next = NULL;
		L[hashvalue]->tail = New;
	}
	L[hashvalue]->size++;
}
bool Contains(list **L, int key)
{
	int i;
	for (int i = 0; i < MOD; i++) {
		L[i]->cur = L[i]->head;

		while (L[i]->cur) {
			if (L[i]->cur->data == key)
				return true;
			L[i]->cur = L[i]->cur->next;
		}
		printf("\n");

	}
	return false;
}

void Deque(list** L, int key)
{
	node* temp;
	int hash_value = key % MOD;
	if (L[hash_value]->size == 1)
		L[hash_value]->head = L[hash_value]->tail = NULL;
	else if (L[hash_value]->size == 2) {
		temp = L[hash_value]->tail;
		L[hash_value]->head->next = NULL;
		L[hash_value]->tail = L[hash_value]->head;
		free(temp);
	}
	else {
		temp = L[hash_value]->tail;
		L[hash_value]->cur = L[hash_value]->head;
		while (L[hash_value]->cur->next != L[hash_value]->tail) L[hash_value]->cur = L[hash_value]->cur->next;
		free(temp);
		L[hash_value]->cur->next = NULL;
		L[hash_value]->tail = L[hash_value]->cur;
	}
	L[hash_value]->size--;
}

void RemoveKey(list ** L, int key)
{
	int hash_value = key % MOD;
	node* temp = (node*)malloc(sizeof(node));
	while (L[hash_value]->size != 0) Deque(L, key);

	L[hash_value]->size = 0;

}

int CollisionMaxCount(list ** L)
{
	int max = L[0]->size;
	int i;

	for (i = 1; i < MOD; i++)
		if (max < L[i]->size)
			max = L[i]->size;
	return max;
}

void Print(list ** L)
{
	int i;
	for (int i = 0; i < MOD; i++) {
		printf("L[%d]: ", i);
		L[i]->cur = L[i]->head;
		printf("%d  ", L[i]->size);

		while (L[i]->cur) {
			printf("%d -> ", L[i]->cur->data);
			L[i]->cur = L[i]->cur->next;
		}
		printf("\n");

	}

}


