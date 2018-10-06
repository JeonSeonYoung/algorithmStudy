/*
1.리스트 가운데서 하나의 원소를 고른다. 이렇게 고른 원소를 피벗이라고 한다.
2.피벗 앞에는 피벗보다 값이 작은 모든 원소들이 오고, 피벗 뒤에는 피벗보다 값이 큰 모든 원소들이 오도록 피벗을 기준으로 리스트를 둘로 나눈다. 이렇게 리스트를 둘로 나누는 것을 분할이라고 한다. 분할을 마친 뒤에 피벗은 더 이상 움직이지 않는다.
3.분할된 두 개의 작은 리스트에 대해 재귀(Recursion)적으로 이 과정을 반복한다. 재귀는 리스트의 크기가 0이나 1이 될 때까지 반복된다.
*/


//퀵정렬2

//<퀵정렬2>

#include <stdio.h>
#include <stdlib.h> //랜덤함수 호출

void Swap(int arr[], int a, int b);
int Partition(int arr[], int left, int right);
void QuickSort(int arr[], int left, int right);

//메인함수
int main()
{
	int n, i;
	int arr[100];


	printf("정렬할 숫자의 갯수를 입력하시오.");
	scanf_s("%d", &n);

	for (i = 0; i < n; i++)
		arr[i] = rand() % 1000;

	printf("정렬전 배열 :");
	for (i = 0; i < n; i++)
		printf("%d ", arr[i]);
	printf("\n");

	QuickSort(arr, 0, n - 1);

	printf("정렬후 배열 :");
	for (i = 0; i < n; i++)
		printf("%d ", arr[i]);
	printf("\n");

	return 0;
}

void Swap(int arr[], int a, int b) // a,b 스왑 함수 
{
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
}

int Partition(int arr[], int left, int right)
{
	int pivot = arr[left]; // 피벗의 위치는 가장 왼쪽에서 시작
	int low = left + 1;
	int high = right;

	while (low <= high) // 교차되기 전까지 반복한다 
	{
		while (pivot >= arr[low] && low <= right) // 피벗보다 큰 값을 찾는 과정 
		{
			low++; // low를 오른쪽으로 이동 
		}

		while (pivot <= arr[high] && high >= low) // 피벗보다 작은 값을 찾는 과정 
		{
			high--; // high를 왼쪽으로 이동
		}

		if (low <= high)// 교차되지 않은 상태이면 스왑 과정 실행 
		{
			Swap(arr, low, high); //low와 high를 스왑 
		}
	}
	Swap(arr, left, high); // 피벗(left)과 high가 가리키는 대상을 교환 
						   // 교체되지않은 high인덱스는  arr[high]==arr[low],pivot보다 작은 값이므로 바꿈  
//	printf("high: %d,arr[high]:%d \n", high,arr[high]);

	return high;  // 옮겨진 피벗의 위치정보를 반환 
}

void QuickSort(int arr[], int left, int right)
{
	if (left <= right)
	{
		int pivot = Partition(arr, left, right); // 둘로 나누어서
		QuickSort(arr, left, pivot - 1); // 왼쪽 영역을 정렬한다.
		QuickSort(arr, pivot + 1, right); // 오른쪽 영역을 정렬한다.
	}
}
