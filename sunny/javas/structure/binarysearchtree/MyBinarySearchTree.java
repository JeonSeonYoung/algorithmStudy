package binary_tree;

public class MyBinarySearchTree {

    private class Node{
        private char data;
        private Node left;
        private Node right;

        private Node(char data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public MyBinarySearchTree(){
        this.root = null;
    }

    public void put(char data){
        Node newNode = new Node(data);
        // 루트가 널이면 처음 등록
        if(this.root == null){
            this.root = newNode;
            return;
        }
        Node currNode = root;
        Node parentNode = null;
        while(true){
            parentNode = currNode;
            // 입력 data가 기존 root 값보다 작으면 왼쪽 노드로 등록
            if(data < currNode.data){
                currNode = currNode.left;
                if(currNode == null){
                    parentNode.left = newNode;
                    return;
                }
            // 입력 data가 기존 root 값보다 크면 오른쪽 노드로 등록
            }else{
                currNode = currNode.right;
                if(currNode == null){
                    parentNode.right = newNode;
                    return;
                }
            }
        }
    }

    // 전위순회
    public void preOrder(){
        preOrder(this.root);
        System.out.println();
    }

    private void preOrder(Node currNode){
        if(currNode != null){
            System.out.print(currNode.data + " - ");
            preOrder(currNode.left);
            preOrder(currNode.right);
        }
    }

    // 중위순회
    public void inOrder(){
        inOrder(this.root);
        System.out.println();
    }

    private void inOrder(Node currNode){
        if(currNode != null){
            inOrder(currNode.left);
            System.out.print(currNode.data + " - ");
            inOrder(currNode.right);
        }
    }

    // 후위순회
    public void postOrder(){
        postOrder(this.root);
        System.out.println();
    }

    private void postOrder(Node currNode){
        if(currNode != null){
            postOrder(currNode.left);
            postOrder(currNode.right);
            System.out.print(currNode.data + " - ");
        }
    }

    public boolean contains(char data){
        boolean result = false;
        Node currNode = root;
        while(currNode != null){
            if(data < currNode.data){
                currNode = currNode.left;
            }else if(data > currNode.data){
                currNode = currNode.right;
            }else{
                result = true;
                return result;
            }
        }
        return result;
    }

    public char getParentData(char data){
        Node currNode = root;
        Node parentNode = root;
        while(currNode != null){
            if(data < currNode.data){
                parentNode = currNode;
                currNode = currNode.left;
            }else if(data > currNode.data){
                parentNode = currNode;
                currNode = currNode.right;
            }else{
                return parentNode.data;
            }
        }
        return parentNode.data;
    }

    //삭제
    public void remove(char data){
        Node parentNode = this.root;
        Node currNode = this.root;
        boolean isLeftChild = false;
        while(currNode.data != data){
            parentNode = currNode;
            if(data < currNode.data){
                isLeftChild = true;
                currNode = currNode.left;
            }else{
                isLeftChild = false;
                currNode = currNode.right;
            }
        }

        // 자식 노드가 모두 없는 경우
        if(currNode.left == null && currNode.right == null) {
            // 그게 자식이 없는 루트라면 그냥 루트를 null로..
            if (currNode == this.root) {
                this.root = null;
            }
            // 왼쪽에 자식이 삭제할 데이터라면
            if(isLeftChild){
                parentNode.left = null;
            }else{
                parentNode.right = null;
            }
        // 왼쪽 자식이 없다면
        }else if(currNode.left ==  null){
            // 그게 루트라면 오른쪽 자식을 루트로
            if(currNode == this.root){
                this.root = currNode.right;
            }
            if(isLeftChild){
                // 삭제되는 것이 왼쪽 노드이기 때문에 현재의 오른쪽 노드를 왼쪽으로 이동
                parentNode.left = currNode.right;
            }else{
                // 삭제되는 것이 오른쪽 노드라면 그대로 오른쪽 노드를 위로 땡김.
                parentNode.right = currNode.right;
            }
        // 오른쪽 자식이 없다면
        }else if(currNode.right == null){
            // 그게 루트라면 왼쪽 자식을 루트로
            if(currNode == this.root){
                this.root = currNode.left;
            }
            if(isLeftChild){
                parentNode.left = currNode.left;
            }else{
                parentNode.right = currNode.left;
            }
        // 양쪽 모두 자식이 있는 경우
        }else if(currNode.left != null && currNode.right != null){
            // 오른쪽 서브 트리의 최소값 노드 반환
            Node minNode = this.getMinNode(currNode);
            if(currNode == this.root){
                this.root = minNode;
            }
            if(isLeftChild){
                parentNode.left = minNode;
            }else{
                parentNode.right = minNode;
            }
            // 부모의 오른쪽 서브를 통해서 가져온 노드이기 때문에 부모의 왼쪽 서브를 다시 연결해줘야 함.
            minNode.left = currNode.left;
        }
    }

    // 가장 작은 노드 가져오기
    private Node getMinNode(Node delNode){
        Node minNode = null;
        Node parentMinNode = null;
        // 오른쪽 서브 트리를 선택함
        Node currentNode = delNode.right;
        while (currentNode != null){
            parentMinNode = minNode;
            minNode = currentNode;
            currentNode = currentNode.left;
        }
        if(minNode != delNode.right){
            parentMinNode.left = minNode.right;
            minNode.right = delNode.right;
        }
        return minNode;
    }
}
