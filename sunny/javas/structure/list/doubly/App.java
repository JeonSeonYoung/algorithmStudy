package javas.list.doubly;

public class App {

    public static void main(String[] args) {

        MyDoublyLinkedList doublyLinkedList = new MyDoublyLinkedList();

//        doublyLinkedList.addFirst("data_0");
//        System.out.println(doublyLinkedList);
//        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
//        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());
//
//        doublyLinkedList.addFirst("data_1");
//        System.out.println(doublyLinkedList);
//        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
//        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());
//
//        doublyLinkedList.clear();
//        System.out.println(doublyLinkedList);
//        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
//        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());


        doublyLinkedList.addLast("data_0");
        System.out.println(doublyLinkedList);
        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());

        doublyLinkedList.addLast("data_1");
        System.out.println(doublyLinkedList);
        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());

        doublyLinkedList.addFirst("data_2");
        System.out.println(doublyLinkedList);
        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());

        doublyLinkedList.add(1, "data_3");
        System.out.println(doublyLinkedList);
        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());

        doublyLinkedList.add(5, "data_4");
        System.out.println(doublyLinkedList);
        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());

        doublyLinkedList.add(0, "data_5");
        System.out.println(doublyLinkedList);
        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());

        doublyLinkedList.removeFirst();
        System.out.println(doublyLinkedList);
        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());

        doublyLinkedList.removeLast();
        System.out.println(doublyLinkedList);
        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());
        System.out.println(doublyLinkedList.indexOf("data_0"));

        doublyLinkedList.remove(1);
        System.out.println(doublyLinkedList);
        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());

        doublyLinkedList.remove(2);
        System.out.println(doublyLinkedList);
        System.out.println("head data:::::::::"+doublyLinkedList.getHeadNodeData());
        System.out.println("tail data:::::::::"+doublyLinkedList.getTailNodeData());

        System.out.println(doublyLinkedList.size());
        System.out.println(doublyLinkedList.indexOf("data_0"));
        System.out.println(doublyLinkedList.indexOf("data_4"));
        System.out.println(doublyLinkedList.contains("data_4"));
        System.out.println(doublyLinkedList.contains("data_0"));

    }

}
