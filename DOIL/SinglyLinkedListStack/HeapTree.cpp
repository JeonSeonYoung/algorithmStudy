#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAXNODE 10
 
void Insert();
void Arrange();
int Remove(int RemoveIndex);

int Node[MAXNODE + 1] = { 0, };

int main(void)
{
	
	int i = 0;
	int MaxValue;
	int RemoveNum;

	Insert();
	printf("\n");
	for (i = 1; i < MAXNODE + 1; i++)
		printf(" OverlapCheck Node[%d] = %d \n" ,i,Node[i]);
	printf("\n");
	
	Arrange();
	for (i = 1; i < MAXNODE + 1; i++)
		printf(" Arrange Node[%d] = %d \n", i, Node[i]);
	
	printf("\n");
	printf("지울 노드 번호를 입력하세요:");
	scanf_s("%d", &RemoveNum);

	MaxValue = Remove(RemoveNum);
	printf("MaxValue = %d\n", MaxValue);

	
	return 0;
}

void Insert()
{
	int i,j;

	srand((unsigned int)time(NULL));

	for (i = 1; i < MAXNODE+1;i++) {
		Node[i] = rand()%20;
		printf("Node[%d] = %d\n", i, Node[i]);					//중복체크 하기 전 Node의 값들
		if(i>1){											 
			for (j = 1; j < i; j++) { 							//i번 째와 1 ~ (i-1)번 째 값을 비교하여
				if (Node[i] == Node[j]) {				// 배열의 데이터 값이 중복될 경우
					Node[i] = rand() % 20;				//Node[i]의 데이터 값을 중복이 안될 때까지  다시 넣는다.
					j = 1;					
				}
				//continue;		
			}
		}		
	}
}

void Arrange()
{
	int i;
	int ParentNode;													
	int Tempi;														//부모노드와 대소비교 시의 자식노드
	int temp;

	for (i = 2; i < MAXNODE + 1; i++) {
		ParentNode = i / 2;											
		Tempi = i;
		while (ParentNode >= 1) {
			if (Node[ParentNode] < Node[Tempi]) {
				temp = Node[ParentNode];
				Node[ParentNode] = Node[Tempi];
				Node[Tempi] = temp;
				ParentNode /= 2;
				Tempi /= 2;
			}
			else break;
		}
		
	}
}

int Remove(int RemoveIndex)
{
	int MaxValue;

	if (RemoveIndex == 1)
		MaxValue = (Node[2] > Node[3]) ?  Node[2] :  Node[3];
	
	else MaxValue = Node[1];

	return  MaxValue;
}
