package javas.Queue;

public class MyCircularQueue implements lQueue{

    private int front;
    private int rear;
    private final int maxSize;
    private Object[] data;

    public MyCircularQueue(int maxSize){
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
        this.data = new Object[maxSize];
    }

    @Override
    public Boolean isEmpty() {
        if(rear == front){
            return true;
        }
        return false;
    }

    @Override
    public Boolean isFull() {
        if((front%maxSize) == ((rear+1)%maxSize)){
            return true;
        }
        return false;
    }

    @Override
    public Object peek() {
        Object result = null;
        if(!isEmpty()){
            int lFront = (front+1) % maxSize;
            result = this.data[lFront];
        }
        return result;
    }

    @Override
    public void remove() {
        if(!isEmpty()){
            front = (front+1) % maxSize;
            this.data[front] = null;
        }
    }

    @Override
    public void insert(Object data) {
        if(!isFull()){
            rear = (rear+1)%maxSize;
            this.data[rear] = data;
        }else{
            System.out.println("꽉 차서 더이상 등록 못함.");
        }
    }

    @Override
    public int size() {
        return this.maxSize;
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
