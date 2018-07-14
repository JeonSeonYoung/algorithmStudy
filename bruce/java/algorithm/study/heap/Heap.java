package algorithm.study.heap;

/**
 * 조건
 * complete binary tree 여야 함
 * 같은 값이면 부모자식 관계가 되면 안됨
 *
 * 배열 tree (1-index)
 * parent : i/2
 * lchild : i*2
 * rchild : i*2+1
 */
public interface Heap<T> {
    /*
    * heap 삽입
    * 완전 트리가 되도록 우선 삽입 - 배열 구현이 더 쉬움
    * 같은 값이 삽입 된 경우 - 완전 트리의 위치에 넣엇을때 부모자식 관계가 된다면 빈 공간 할당 후 다음 후보 위치에 넣음
    * */
    void put(T value);
    /*
    * root 제거
    * root 제외한 나머지 tree 에 대한 정렬
    * 완전 트리 마지막 후보 index 의 value 를 root 로 이동
    * root 의 left subtree, right subtree 로부터 root 보다 작거나 큰 값와 swap
    * */
    T pop();
    // # of actual nodes
    int size();
    int level();

    void print();
}
