package javas.heap;

public class App {

    public static void main(String[] args){

        MyHeap heap = new MyHeap(10);

        heap.insertHeap(2);
        heap.insertHeap(5);
        heap.insertHeap(12);
        heap.insertHeap(3);
        heap.insertHeap(20);
        heap.insertHeap(13);
        heap.insertHeap(13);

        System.out.println(heap);

        heap.deleteHeap();
        heap.deleteHeap();

        System.out.println(heap);

        heap.insertHeap(7);

        System.out.println(heap);

        heap.deleteHeap();

        System.out.println(heap);

    }
}
