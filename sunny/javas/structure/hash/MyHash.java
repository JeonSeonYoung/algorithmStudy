package hash;

public class MyHash {

    private class Node{
        private int key;
        private Node next;
    }

    private int size;
    private Node[] hashTable;

    public MyHash(int size){
        this.size = size;
        this.hashTable = new Node[size];
    }

    private int hashMethod(int key){
        return key % this.size;
    }

    public boolean contains(int key){
        int idx = this.hashMethod(key);
        Node curNode = this.hashTable[idx];
        while(curNode != null){
            if(curNode.key == key){
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    public void put(int key){
        int idx = this.hashMethod(key);
        Node newData = new Node();
        newData.key = key;
        newData.next = null;
        if(this.hashTable[idx] == null){
            this.hashTable[idx] = newData;
        }else{
            Node prevNode = this.hashTable[idx];
            while(prevNode.next != null){
                prevNode = prevNode.next;
                if(prevNode.next == null){
                    prevNode.next = newData;
                    return;
                }
            }
            prevNode.next = newData;
        }
    }

    public Integer collisionMaxCount(){
        int maxCount = 0;
        for(Node node : this.hashTable){
            int count = 0;
            while(node != null){
                count++;
                node = node.next;
            }
            if(count > maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }

    public void removeKey(int key){
        int idx = this.hashMethod(key);
        this.hashTable[idx] = null;
    }

    @Override
    public String toString(){

        StringBuffer result = new StringBuffer();
        Node cur = null;

        for(int i=0; i<size; i++){

            result.append("[" + i + "]\t");
            cur = hashTable[i];

            if(cur == null){
                result.append("null ");

            }else{

                while(cur!=null){
                    result.append(cur.key + " - ");
                    cur = cur.next;
                }
            }
            result.append("\n");
        }

        return result.toString();

    }


}
