package javas.Queue;

public class App {

    public static void main(String[] args) {

        // 선형큐 테스트
//        MyLinearQueue linearQueue = new MyLinearQueue(5);
//
//        System.out.println("큐 데이터 비었니? "+ linearQueue.isEmpty());
//        System.out.println("-----------------------------------------------------");
//
//        linearQueue.insert("data_0");
//        System.out.println("큐 데이터 등록: "+ linearQueue);
//        linearQueue.insert("data_1");
//        System.out.println("큐 데이터 등록: "+ linearQueue);
//        System.out.println("-----------------------------------------------------");
//
//        System.out.println("큐 데이터 훔쳐보기: "+ linearQueue.peek());
//        System.out.println("-----------------------------------------------------");
//
//        linearQueue.remove();
//        System.out.println("큐 데이터 제거하기: "+ linearQueue);
//        System.out.println("-----------------------------------------------------");
//
//        linearQueue.insert("data_2");
//        System.out.println("큐 데이터 등록: "+ linearQueue);
//        System.out.println("-----------------------------------------------------");
//
//        System.out.println("큐 데이터 비었니? "+ linearQueue.isEmpty());
//        System.out.println("-----------------------------------------------------");
//
//        linearQueue.insert("data_3");
//        System.out.println("큐 데이터 등록: "+ linearQueue);
//        linearQueue.insert("data_4");
//        System.out.println("큐 데이터 등록: "+ linearQueue);
//        System.out.println("-----------------------------------------------------");
//
//        System.out.println("큐 데이터 찼니? "+ linearQueue.isFull());
//        System.out.println("-----------------------------------------------------");
//
//        linearQueue.remove();
//        System.out.println("큐 데이터 제거하기: "+ linearQueue);
//        System.out.println("-----------------------------------------------------");
//        linearQueue.remove();
//        System.out.println("큐 데이터 제거하기: "+ linearQueue);
//        System.out.println("-----------------------------------------------------");
//
//        System.out.println("큐 데이터 비었니? "+ linearQueue.isEmpty());
//        System.out.println("-----------------------------------------------------");



        // 원형 큐 테스트
        MyCircularQueue myCircularQueue = new MyCircularQueue(5);

        System.out.println("큐 데이터 비었니? "+ myCircularQueue.isEmpty());
        System.out.println("-----------------------------------------------------");

        myCircularQueue.insert("data_0");
        System.out.println("큐 데이터 등록: "+ myCircularQueue);
        myCircularQueue.insert("data_1");
        System.out.println("큐 데이터 등록: "+ myCircularQueue);
        System.out.println("-----------------------------------------------------");

        System.out.println("큐 데이터 훔쳐보기: "+ myCircularQueue.peek());
        System.out.println("-----------------------------------------------------");

        myCircularQueue.remove();
        System.out.println("큐 데이터 제거하기: "+ myCircularQueue);
        System.out.println("-----------------------------------------------------");

        myCircularQueue.insert("data_2");
        System.out.println("큐 데이터 등록: "+ myCircularQueue);
        System.out.println("-----------------------------------------------------");

        System.out.println("큐 데이터 비었니? "+ myCircularQueue.isEmpty());
        System.out.println("-----------------------------------------------------");

        myCircularQueue.insert("data_3");
        System.out.println("큐 데이터 등록: "+ myCircularQueue);
        myCircularQueue.insert("data_4");
        System.out.println("큐 데이터 등록: "+ myCircularQueue);
        System.out.println("-----------------------------------------------------");

        System.out.println("큐 데이터 찼니? "+ myCircularQueue.isFull());
        System.out.println("-----------------------------------------------------");

        myCircularQueue.remove();
        System.out.println("큐 데이터 제거하기: "+ myCircularQueue);
        System.out.println("-----------------------------------------------------");
        myCircularQueue.remove();
        System.out.println("큐 데이터 제거하기: "+ myCircularQueue);
        System.out.println("-----------------------------------------------------");

        System.out.println("큐 데이터 비었니? "+ myCircularQueue.isEmpty());
        System.out.println("-----------------------------------------------------");

    }
}
