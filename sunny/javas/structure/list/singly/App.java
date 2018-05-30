package list;

public class App {
    public static void main(String[] args) {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList();

        mySinglyLinkedList.addFirst("data_0");
        System.out.println("addFirst ::::::"+ mySinglyLinkedList);
        mySinglyLinkedList.removeFirst();
        System.out.println("removeFirst:::::"+ mySinglyLinkedList);
        mySinglyLinkedList.addFirst("data_1");
        System.out.println("addFirst ::::::"+ mySinglyLinkedList);
        mySinglyLinkedList.removeLast();
        System.out.println("removeLast ::::::"+ mySinglyLinkedList);
        mySinglyLinkedList.addLast("data_2");
        System.out.println("addLast ::::::"+ mySinglyLinkedList);
        mySinglyLinkedList.addLast("data_3");
        System.out.println("addLast ::::::"+ mySinglyLinkedList);
        mySinglyLinkedList.add(1,"data_4");
        System.out.println("add ::::::"+ mySinglyLinkedList);
        mySinglyLinkedList.removeFirst();
        System.out.println("removeFirst ::::::"+ mySinglyLinkedList);
        System.out.println("size ::::::"+ mySinglyLinkedList.size());
        mySinglyLinkedList.remove(1);
        System.out.println("remove ::::::"+ mySinglyLinkedList);

        mySinglyLinkedList.addLast("data_1");
        mySinglyLinkedList.addLast("data_2");
        mySinglyLinkedList.addLast("data_3");
        System.out.println("데이터 쭉 등록:::::"+ mySinglyLinkedList);

        System.out.println("인덱스 2번째 데이터 가져오기:::::"+ mySinglyLinkedList.get(2));
        System.out.println("data_3 포함 되어있니?:::::::"+ mySinglyLinkedList.contains("data_3"));
        System.out.println("data_3은 몇번째 인덱스니?:::::"+ mySinglyLinkedList.indexOf("data_3"));
    }
}
