package javas.Stack;

public class MyStack implements lStack {

    private Object[] data;
    private int top;
    private static int maxSize;

    public MyStack(int maxSize){
        this.data = new Object[maxSize];
        this.top = -1;
        this.maxSize = maxSize;
    }

    @Override
    public void push(Object data) {
        if(!isFull()){
            this.data[++top] = data;
        }else {
            System.out.println("배열이 꽉 차서 등록할 수 없습니다.");
        }
    }

    @Override
    public Object pop() {
        Object result = null;
        if(!isEmpty()){
            result = this.data[top];
            this.data[top] = null;
            top--;
        }else{
            System.out.println("배열이 비어있습니다.");
        }
        return result;
    }

    @Override
    public Object peek() {
        Object result = null;
        if(!isEmpty()){
            result = this.data[top];
        }else{
            System.out.println("배열이 비어있습니다.");
        }
        return result;
    }

    @Override
    public Integer size() {
        return this.top+1;
    }

    @Override
    public void clear() {
        if(!isEmpty()) {
            for (int i = 0; i <= top; ++i) {
                this.data[i] = null;
            }
            top = -1;
        }
    }

    @Override
    public boolean isEmpty() {
        boolean result = false;
        if(top == -1){
            result = true;
        }
        return result;
    }

    @Override
    public boolean isFull() {
        boolean result = false;
        if(top == maxSize-1){
            result = true;
        }
        return result;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer("[");
        if(top>-1) {
            sb.append(data[0]);
            for (int i = 1; i < maxSize; ++i) {
                sb.append(", ").append(data[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }



}
