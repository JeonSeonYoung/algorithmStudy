#pragma once

template < typename T>
struct Node {
	T value;
	Node *pNext;
};

template < typename T>
struct Node_Dual {
	T value;
	Node_Dual *pNext;
	Node_Dual *pPrev;
};