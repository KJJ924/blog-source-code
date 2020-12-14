package live_study_05.option;

public class BinaryTree {
    public Node root;

    private class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getValue() {
            return value;
        }

    }
    public boolean find(int value){
        Node currentNode =root;
        while (currentNode!=null){
            if(currentNode.getValue()==value){
                return true;
            }else if(currentNode.getValue() >value) {
                currentNode = currentNode.getLeft();
            }else {
                currentNode = currentNode.getRight();
            }
        }
        return false;
    }

    public void insert(int value){
        Node newNode = new Node(value);
        if(find(value)){
            System.out.println("중복값입니다.");
            return;
        }
        if(root == null){
            root =newNode;
            return;
        }
        Node currentNode = root;
        Node parent;
        while (true){
            parent = currentNode;
            if(value<currentNode.getValue()){
                currentNode = currentNode.getLeft();
                if(currentNode==null){
                    parent.setLeft(newNode);
                    return;
                }
            }else {
                currentNode = currentNode.getRight();
                if(currentNode==null){
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }
    public void inOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.getLeft());
            System.out.print(focusNode.getValue() + " ");
            inOrderTraverse(focusNode.getRight());
        }
    }
    public void postOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverse(focusNode.getLeft());
            postOrderTraverse(focusNode.getRight());
            System.out.print(focusNode.getValue() + " ");

        }
    }
    public void preOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode.getValue() + " ");
            preOrderTraverse(focusNode.getLeft());
            preOrderTraverse(focusNode.getRight());
        }
    }

}
