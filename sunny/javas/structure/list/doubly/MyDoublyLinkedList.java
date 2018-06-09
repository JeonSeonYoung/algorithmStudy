package javas.list.doubly;

public class MyDoublyLinkedList implements lList{

    private Node head;
    private Node tail;
    private int size;

    public MyDoublyLinkedList(){
        this.size = 0;
    }

    @Override
    public void addFirst(Object obj) {
        Node newNode = new Node(obj);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else{
            newNode.setNextNode(this.head);
            this.head.setPrevNode(newNode);
            this.head = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(Object obj) {
        Node newNode = new Node(obj);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else{
            newNode.setPrevNode(this.tail);
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public void removeFirst() {
        if(isEmpty()){
            System.out.println("데이터가 비어있습니다.");
        }else{
            if(this.size ==1){
                this.clear();
                return;
            }
            Node nextNode = this.head.getNextNode();
            this.head = nextNode;
            nextNode.setPrevNode(null);
            this.size--;
        }
    }

    @Override
    public void removeLast() {
        if(isEmpty()){
            System.out.println("데이터가 비어있습니다.");
        }else{
            if(this.size == 1){
                this.clear();
                return;
            }
            Node prevNode = this.tail.getPrevNode();
            this.tail = prevNode;
            prevNode.setNextNode(null);
            this.size--;
        }
    }

    public Node getCurrentNode(int idx){
        Node currentNode = null;
        if(!isEmpty()) {
            currentNode = this.head;
            for (int i = 1; i <= idx; ++i) {
                currentNode = currentNode.getNextNode();
            }
        }
        return currentNode;
    }

    @Override
    public void add(int idx, Object obj) {
        if(idx == 0){
            addFirst(obj);
            return;
        }else if(idx+1 >= this.size){
            addLast(obj);
            return;
        }
        Node newNode = new Node(obj);
        Node currentNode = this.getCurrentNode(idx);
        newNode.setPrevNode(currentNode.getPrevNode());
        newNode.setNextNode(currentNode);
        currentNode.getPrevNode().setNextNode(newNode);
        currentNode.setPrevNode(newNode);
        this.size++;

    }

    @Override
    public void remove(int idx) {
        if(isEmpty()){
            System.out.println("데이터가 비어있습니다.");
        }else{
            if(idx ==0 || this.size ==1){
                this.removeFirst();
                return;
            }
            if(this.size <= idx+1){
                this.removeLast();
                return;
            }
            Node currentNode = this.getCurrentNode(idx);
            Node prevNode = currentNode.getPrevNode();
            Node nextNode = currentNode.getNextNode();
            prevNode.setNextNode(nextNode);
            this.size--;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    @Override
    public Boolean isEmpty() {
        Boolean result = false;
        if(this.size == 0){
            result = true;
        }
        return result;
    }

    @Override
    public int indexOf(Object obj) {
        if(!isEmpty()){
            Node currentNode = this.head;
            if(currentNode.getObj().equals(obj)){
                return 0;
            }
            for(int i =1; i<this.size; ++i){
                currentNode = currentNode.getNextNode();
                if(currentNode.getObj().equals(obj)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Boolean contains(Object obj) {
        Node currentNode = this.head;
        if(currentNode.getObj().equals(obj)){
            return true;
        }
        for(int i =1; i<this.size; ++i){
            currentNode = currentNode.getNextNode();
            if(currentNode.getObj().equals(obj)){
                return true;
            }
        }
        return false;
    }

    public Object getHeadNodeData(){
        return this.head.getObj();
    }

    public Object getTailNodeData(){
        return this.tail.getObj();
    }

    @Override
    public String toString(){

        StringBuffer result = new StringBuffer("[");
        if(this.size >0){
            result.append(this.head.getObj());
            Node node = this.head.getNextNode();

            while(node != null){
                result.append(", ");
                result.append(node.getObj());
                node = node.getNextNode();
            }
        }
        result.append("]");
        return result.toString();
    }
}
