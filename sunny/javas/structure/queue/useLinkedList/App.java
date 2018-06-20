package queue.useLinkedList;


public class App {

    public static void main(String[] args) {

        // 선형큐 테스트
        MyLinearQueue linearQueue = new MyLinearQueue();

        System.out.println("큐 데이터 비었니? "+ linearQueue.isEmpty());
        System.out.println("-----------------------------------------------------");

        linearQueue.insert("data_0");
        System.out.println("큐 데이터 등록: "+ linearQueue);
        linearQueue.insert("data_1");
        System.out.println("큐 데이터 등록: "+ linearQueue);
        System.out.println("-----------------------------------------------------");

        System.out.println("큐 데이터 훔쳐보기: "+ linearQueue.peek());
        System.out.println("-----------------------------------------------------");

        linearQueue.remove();
        System.out.println("큐 데이터 제거하기: "+ linearQueue);
        System.out.println("-----------------------------------------------------");

        linearQueue.insert("data_2");
        System.out.println("큐 데이터 등록: "+ linearQueue);
        System.out.println("-----------------------------------------------------");

        System.out.println("큐 데이터 비었니? "+ linearQueue.isEmpty());
        System.out.println("-----------------------------------------------------");

        linearQueue.insert("data_3");
        System.out.println("큐 데이터 등록: "+ linearQueue);
        linearQueue.insert("data_4");
        System.out.println("큐 데이터 등록: "+ linearQueue);
        System.out.println("-----------------------------------------------------");

        linearQueue.remove();
        System.out.println("큐 데이터 제거하기: "+ linearQueue);
        System.out.println("-----------------------------------------------------");
        linearQueue.remove();
        System.out.println("큐 데이터 제거하기: "+ linearQueue);
        System.out.println("-----------------------------------------------------");

        System.out.println("큐 데이터 비었니? "+ linearQueue.isEmpty());
        System.out.println("-----------------------------------------------------");

        System.out.println("front data::::" + linearQueue.getFrontData());
        System.out.println("rear data::::" + linearQueue.getRearData());

        linearQueue.remove();
        System.out.println("큐 데이터 제거하기: "+ linearQueue);
        System.out.println("-----------------------------------------------------");

        System.out.println("front data::::" + linearQueue.getFrontData());
        System.out.println("rear data::::" + linearQueue.getRearData());

        linearQueue.remove();
        System.out.println("큐 데이터 제거하기: "+ linearQueue);
        System.out.println("-----------------------------------------------------");

        System.out.println("front data::::" + linearQueue.getFrontData());
        System.out.println("rear data::::" + linearQueue.getRearData());

    }
}
