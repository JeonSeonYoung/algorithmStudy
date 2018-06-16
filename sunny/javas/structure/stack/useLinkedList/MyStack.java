package stack.useLinkedList;

public class MyStack implements lStack{

    private Node top;
    private int size;

    public MyStack(){
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(Object data) {
        Node newNode = new Node(data);
        if(!isEmpty()){
            newNode.setNextNode(this.top);
        }
        this.top = newNode;
        this.size++;
    }

    @Override
    public Object pop() {
        Object result = null;
        if(isEmpty()){
            System.out.println("데이터가 비어있습니다.");
            return result;
        }
        result = this.top.getData();
        this.top = this.top.getNextNode();
        this.size--;
        return result;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            System.out.println("데이터가 비어있습니다.");
            return null;
        }
        return this.top.getData();
    }

    @Override
    public Integer size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        if(this.top == null){
            return true;
        }
        return false;
    }

    // 사이즈 제한 없앰.
    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString(){

        StringBuffer result = new StringBuffer("[");
        if(this.size >0){
            result.append(this.top.getData());
            Node node = this.top.getNextNode();

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
