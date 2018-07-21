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
	int CurNode = Node[RemoveIndex];
	int LeftChild = Node[RemoveIndex*2];
	int RightChild= Node[RemoveIndex * 2+1];
	int LastRemove;
	int LastLeftChild;
	int	LastRightChild;
	int i;
	if (RemoveIndex == 1) {
		MaxValue = (LeftChild > RightChild) ?  LeftChild : RightChild;
	}
	else MaxValue = Node[1];

	while (2 * RemoveIndex <= MAXNODE){												//자식이 없는 노드가 나올 때까지
		LastRemove = RemoveIndex;													//옮길 노드중 마지막으로 자식이 있는 노드
		LastLeftChild = LeftChild;													//옮길 노드의 자식이 없는 마지막 왼쪽 자식
		LastRightChild = RightChild;												//옮길 노드의 자식이 없는 마지막 오른쪽 자식
		if (LeftChild > RightChild) {												//왼쪽 자식과 오른쪽 자식의 대소비교
			Node[RemoveIndex] = LeftChild;										
			RemoveIndex *= 2;
			LeftChild = Node[RemoveIndex * 2];
			if(RemoveIndex*2+1 <= MAXNODE)
				RightChild = Node[RemoveIndex * 2 + 1];		
			
		}
		else{
			Node[RemoveIndex] = RightChild;
			RemoveIndex = RemoveIndex*2+1;
			LeftChild = Node[RemoveIndex * 2];
			if (RemoveIndex * 2 + 1 <= MAXNODE)
				RightChild = Node[RemoveIndex * 2 + 1];
		}
		
		
	}
	
	printf("LastRemove NodeNum = %d\n", LastRemove);																			//                      1
	printf("LastLeftChild Data= = %d\n", LastLeftChild);																		//                  2       3
	printf("LastRightChild Data= %d\n", LastRightChild);																		//               4     5  6    7
																															    //			   8   9 10			
	if(LastLeftChild>LastRightChild)		Node[LastRemove*2] = 0;
	else Node[LastRemove * 2+1] = 0;
 
	 for (i = 1; i < MAXNODE + 1; i++)												//삭제 후 재정렬
		printf(" After Deleting Node[%d] = %d \n", i, Node[i]);

	return MaxValue;
}
