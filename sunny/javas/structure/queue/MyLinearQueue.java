package javas.Queue;

public class MyLinearQueue implements lQueue {

    private int front;
    private int rear;
    private final int maxSize;
    private Object[] data;

    public MyLinearQueue(int maxSize){
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = -1;
        this.data = new Object[maxSize];
    }

    @Override
    public Boolean isEmpty() {
        Boolean result = false;
        if(front>rear){
            result = true;
        }
        return result;
    }

    @Override
    public Boolean isFull() {
        Boolean result = false;
        if(rear == maxSize-1){
            result = true;
        }
        return result;
    }

    @Override
    public Object peek() {
        Object result = null;
        if(!isEmpty()){
            result = this.data[front];
        }
        return result;
    }

    @Override
    public void remove() {
        if(!isEmpty()){
            this.data[front++] = null;
        }else{
            System.out.println("큐가 비었음");
        }
    }

    @Override
    public void insert(Object data) {
        if(!isFull()){
            this.data[++rear] = data;
        }else{
            System.out.println("꽉 참.");
        }
    }

    @Override
    public int size() {
        return this.rear;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer("[");
        if(rear>-1) {
            sb.append(data[0]);
            for (int i = 1; i < maxSize; ++i) {
                sb.append(", ").append(data[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
