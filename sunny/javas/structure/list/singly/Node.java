package list;

public class Node {
    private Object data;
    private Node nextNode;

    Node(Object data){
        this.data = data;
        this.nextNode = null;
    }

    public Object getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
