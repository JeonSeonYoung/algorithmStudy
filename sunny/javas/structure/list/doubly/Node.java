package javas.list.doubly;

public class Node {

    private Object obj;
    private Node prevNode;
    private Node nextNode;

    public Node(Object obj){
        this.obj = obj;
        this.prevNode = null;
        this.nextNode = null;
    }

    public Object getObj() {
        return obj;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
