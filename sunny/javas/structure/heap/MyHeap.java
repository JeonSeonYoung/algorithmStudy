package javas.heap;

// maxHeap
public class MyHeap {

    private int heapSize;
    private int[] itemHeap;

    public MyHeap(int size){
        this.heapSize = 0;
        this.itemHeap = new int[size];
    }


    private int getParentIdx(int idx){
        return (int) Math.floor(idx/2);
    }

    private int getLeftChildIdx(int idx){
        return 2 * idx;
    }

    private int getRigthChildIdx(int idx){
        return 2 * idx +1;
    }

    public int getHeapSize(){
        return this.heapSize;
    }

    public void insertHeap(int item){
        if(this.getHeapSize() == 0){
            this.itemHeap[1] = item;
            this.heapSize++;
        }else{
            this.itemHeap[this.getHeapSize()+1] = item;
            this.heapSize++;
            int parentItem;
            int currentItem;
            for(int i = this.getHeapSize(); i>1; --i){
                parentItem = this.itemHeap[this.getParentIdx(i)];
                currentItem = this.itemHeap[i];
                // 부모랑 값 비교
                if(parentItem < currentItem){
                    int temp = parentItem;
                    this.itemHeap[this.getParentIdx(i)] = currentItem;
                    this.itemHeap[i] = temp;
                }
            }
        }
    }

    public int deleteHeap(){
        int result = this.itemHeap[1];
        this.itemHeap[1] = this.itemHeap[this.getHeapSize()];
        this.itemHeap[this.getHeapSize()] = 0;
        this.heapSize--;
        int currentItem;
        int leftChildItem;
        int rightChildItem;
        int maxChildItem;
        String type;
        for(int i = 1; i<this.getHeapSize(); ++i){
            currentItem = this.itemHeap[i];
            leftChildItem = this.itemHeap[this.getLeftChildIdx(i)];
            rightChildItem = this.itemHeap[this.getRigthChildIdx(i)];

            if(leftChildItem == 0  && rightChildItem == 0){
                return result;
            }

            if(leftChildItem != 0 && rightChildItem == 0){
                if(currentItem < leftChildItem){
                    int temp = currentItem;
                    this.itemHeap[i] = leftChildItem;
                    this.itemHeap[this.getLeftChildIdx(i)] = temp;
                }
            }else if(leftChildItem == 0){
                if(currentItem < rightChildItem){
                    int temp = currentItem;
                    this.itemHeap[i] = leftChildItem;
                    this.itemHeap[this.getRigthChildIdx(i)] = temp;
                }
            }else{
                // 자식끼리 비교
                if(leftChildItem > rightChildItem){
                    maxChildItem = leftChildItem;
                    type = "left";
                }else{
                    maxChildItem = rightChildItem;
                    type = "right";
                }

                // 큰 자식과 부모 비교
                if(currentItem < maxChildItem){
                    int temp = currentItem;
                    this.itemHeap[i] = maxChildItem;
                    if(type.equals("left")){
                        this.itemHeap[this.getLeftChildIdx(i)] = temp;
                    }else{
                        this.itemHeap[this.getRigthChildIdx(i)] = temp;
                    }
                }
            }

        }

        return result;
    }


    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer("[");
        if(this.getHeapSize()>0) {
            sb.append(this.itemHeap[1]);
            for (int i = 2; i < this.getHeapSize()+1; ++i) {
                sb.append(", ").append(itemHeap[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
