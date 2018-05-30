package list;

public class MySinglyLinkedList implements lList {

    private Node head;
    private Node tail;
    private int size;

    public MySinglyLinkedList(){
        this.size = 0;
    }

    public Node getNode(int idx){
        Node node = null;
        if(idx == 0){
            node = this.head;
        }else{
            for(int i= 1; i<this.size; ++i){
                node = this.head.getNextNode();
            }
        }
        return node;
    }

    @Override
    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if(this.size == 0){
            this.head = newNode;
            this.tail = newNode;
        }else{
            newNode.setNextNode(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(Object data) {
        Node newNode = new Node(data);
        if(this.size == 0){
            this.head = newNode;
            this.tail = newNode;
        }else{
            Node prev = this.tail;
            prev.setNextNode(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public void add(int idx, Object data) {
        Node newNode = new Node(data);
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node prev = this.getNode(idx-1);
        Node next = prev.getNextNode();
        prev.setNextNode(newNode);
        newNode.setNextNode(next);
        this.size++;
    }

    @Override
    public void removeFirst() {
        if(this.size > 0){
            if(this.size == 1){
                clear();
                return;
            }
            Node nextNode = this.head.getNextNode();
            this.head = nextNode;
            if(nextNode.getNextNode() == null){
                this.tail = nextNode;
            }
            this.size--;
        }
    }

    @Override
    public void removeLast() {
        if(this.size > 0){
            if(this.size ==1){
                clear();
                return;
            }
            Node nextNode = this.head.getNextNode();
            while(nextNode != null){
                nextNode = nextNode.getNextNode();
            }
            this.tail = nextNode;
            this.size--;
        }
    }

    @Override
    public void remove(int idx) {
        if(this.size > 0){
            if(this.size == 1){
                clear();
                return;
            }
            Node nextNode = this.head.getNextNode();
            Node prevNode = this.head;
            for(int i = 1; i<idx; ++i){
                prevNode = nextNode;
                nextNode = nextNode.getNextNode();
            }
            nextNode = nextNode.getNextNode();
            prevNode.setNextNode(nextNode);
            if(nextNode == null){
                this.tail = prevNode;
            }
            this.size--;
        }
    }

    @Override
    public Object get(int idx) {
        Object lData = null;
        if(idx<this.size){
            Node nextNode = this.head;
            lData = nextNode.getData();
            for(int i = 1; i<=idx; ++i){
                nextNode = nextNode.getNextNode();
                lData = nextNode.getData();
            }
        }
        return lData;
    }

    @Override
    public Boolean contains(Object data) {
        Boolean result = false;
        if(this.size>0){
            Node lNode = this.head;
            Object lData = lNode.getData();
            for(int i = 1; i<this.size; ++i){
                lNode = lNode.getNextNode();
                lData = lNode.getData();
                if(lData == data){
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int indexOf(Object data) {
        int result = -1;
        if(this.size>0){
            Node lNode = this.head;
            Object lData = lNode.getData();
            for(int i = 1; i<this.size; ++i){
                lNode = lNode.getNextNode();
                lData = lNode.getData();
                if(lData == data){
                    result = i;
                }
            }
        }
        return result;
    }

    @Override
    public String toString(){

        StringBuffer result = new StringBuffer("[");
        if(this.size >0){
            result.append(this.head.getData());
            Node node = this.head.getNextNode();

            while(node != null){
                result.append(", ");
                result.append(node.getData());
                node = node.getNextNode();
            }
        }
        result.append("]");
        return result.toString();
    }

}
