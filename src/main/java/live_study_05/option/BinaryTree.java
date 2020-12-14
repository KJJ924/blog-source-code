package live_study_05.option;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BinaryTree {
    public Node root;

    public static final String IN_ORDER_TRAVERSE = "inOrderTraverse";

    public static final String PRE_ORDER_TRAVERSE = "preOrderTraverse";

    public static final String POST_ORDER_TRAVERSE = "postOrderTraverse";

    private class Node {
        private Node left;
        private Node right;
        private final int value;

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
    private boolean find(int value){
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

    public boolean insert(int value){
        Node newNode = new Node(value);
        if(find(value)){
            return false;
        }
        if(root == null){
            root =newNode;
            return true;
        }
        Node currentNode = root;
        Node parent;
        while (true){
            parent = currentNode;
            if(value<currentNode.getValue()){
                currentNode = currentNode.getLeft();
                if(currentNode==null){
                    parent.setLeft(newNode);
                    return true;
                }
            }else {
                currentNode = currentNode.getRight();
                if(currentNode==null){
                    parent.setRight(newNode);
                    return true;
                }
            }
        }
    }

    public List<Integer> Traverse(Node focusNode ,String oderType){
        List<Integer> integers = new ArrayList<>();
        Method[] methods = BinaryTree.class.getDeclaredMethods();
        Method process = null;
        for (Method method : methods) {
            if(method.getName().equals(oderType)){
                process =method;
            }
        }
        try {
            process.setAccessible(true);
            integers = (List<Integer>) process.invoke(new BinaryTree(),focusNode, integers);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return integers;
    }

    private List<Integer> inOrderTraverse(Node focusNode, List<Integer> integers) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.getLeft(),integers);
            integers.add(focusNode.getValue());
            inOrderTraverse(focusNode.getRight(),integers);
        }
        return integers;
    }

    private List<Integer> postOrderTraverse(Node focusNode,List<Integer> integers) {
        if (focusNode != null) {
            postOrderTraverse(focusNode.getLeft(),integers);
            postOrderTraverse(focusNode.getRight(),integers);
            integers.add(focusNode.getValue());
        }
        return integers;
    }

    private List<Integer> preOrderTraverse(Node focusNode, List<Integer> integers) {
        if (focusNode != null) {
            integers.add(focusNode.getValue());
            preOrderTraverse(focusNode.getLeft(), integers);
            preOrderTraverse(focusNode.getRight(),integers);
        }
        return integers;
    }

    public List<Integer> BFS(Node focusNode){
        if(focusNode == null){
            return null;
        }
        List<Integer> result =  new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(focusNode);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();

                if(poll.getLeft() !=null){
                    queue.add(poll.getLeft());
                }
                if(poll.getRight() !=null){
                    queue.add(poll.getRight());
                }
                result.add(poll.getValue());
            }

        }
        return result;
    }

}
