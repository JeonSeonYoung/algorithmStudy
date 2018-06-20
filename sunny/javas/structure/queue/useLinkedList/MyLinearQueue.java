package queue.useLinkedList;

public class MyLinearQueue implements lQueue {

    private Node front;
    private Node rear;
    private int size;

    public MyLinearQueue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    @Override
    public Boolean isEmpty() {
        if(this.size == 0){
            return true;
        }
        return false;
    }

    // 사이즈를 정하지 않기 때문에 제외
    @Override
    public Boolean isFull() {
        return null;
    }

    @Override
    public Object peek() {
        if(!isEmpty()){
            Object result = this.front.getData();
            return result;
        }
        return "데이터가 비어있습니다.";
    }

    @Override
    public void remove() {
        if(!isEmpty()){
            if(this.size == 1){
               this.clear();
            }else {
                Node frontNode = this.front;
                this.front = frontNode.getNextNode();
                this.size--;
            }
        }
    }

    @Override
    public void insert(Object data) {
        Node newNode = new Node(data);
        if(isEmpty()){
            this.front = newNode;
            this.rear = newNode;
        }else{
            Node frontNode = this.front;
            this.front = newNode;
            this.front.setNextNode(frontNode);
        }
        this.size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    public void clear(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public Object getFrontData(){
        if(!isEmpty()){
            return this.front.getData();
        }
        return "데이터 비어있음";
    }

    public Object getRearData(){
        if(!isEmpty()){
            return this.rear.getData();
        }
        return "데이터 비어 있음";
    }

    @Override
    public String toString(){

        StringBuffer result = new StringBuffer("[");
        if(this.size >0){
            result.append(this.front.getData());
            Node node = this.front.getNextNode();

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
