package javas.Array;


public class MyArray implements lArray{

    private Object[] data;
    private int count;
    private final int size;

    public MyArray(int size){
        this.data = new Object[size];
        this.size = size;
        this.count = 0;
    }

    @Override
    public void add(int idx, Object data) {
        if(idx == count){
            add(data);
            return;
        }
        if(count == size){
            throw new ArrayIndexOutOfBoundsException("배열이 꽉 차서 등록하는데 실패하였습니다.");
        }

        for(int i = count; i>idx; --i){
            this.data[i] = this.data[i-1];
        }
        this.data[idx] = data;
        this.count++;
    }

    @Override
    public void add(Object data) {
        if(count == size){
            throw new ArrayIndexOutOfBoundsException("배열이 꽉 차서 등록하는데 실패하였습니다.");
        }
        this.data[count++] = data;
    }

    @Override
    public void remove(int idx) {
        if(count != 0 && idx<count){
            for(int i = idx; i<count-1; ++i){
                this.data[i] = this.data[i+1];
            }
            this.data[count-1] = null;
            this.count--;
        }
    }

    @Override
    public Object get(int idx) {
        Object result;
        if(count >= idx){
            result = this.data[idx];
        }else{
            throw new ArrayIndexOutOfBoundsException("해당하는 데이터를 찾을 수 없습니다.");
        }
        return result;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public void clear() {
        for(int i=0; i<this.size; ++i){
            this.data[i] = null;
        }
        this.count = 0;
    }

    @Override
    public void replace(int idx, Object data) {
        if(idx <= count){
            this.data[idx] = data;
        }else{
            throw new ArrayIndexOutOfBoundsException("해당하는 데이터를 찾을 수 없어 실패하였습니다.");
        }
    }

    @Override
    public void swap(int idx1, int idx2) {
        if(idx1 <= count && idx2 <= count){
            Object temp = this.data[idx1];
            this.data[idx1] = this.data[idx2];
            this.data[idx2] = temp;
        }
    }

    @Override
    public int find(Object data) {
        int result = -1;
        for(int i= 0; i<count; ++i){
            if(data.equals(this.data[i])){
                result = i;
            }
        }
        return result;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer("[");
        if(count>0) {
            sb.append(data[0]);
            for (int i = 1; i < size; ++i) {
                sb.append(", ").append(data[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
