package live_study_04;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    class Node {
        // data -> value 를 저장하고 있는 필드
        private int data;
        // next  - > 다음 요소를 저장하고있는 필드
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
    // 0번째 에 new Node 를 추가하는 method;
    public Node firstNodeAdd(int value){
        Node newNode = new Node(value);
        //LinkedList 의 head 값이 null 이면 첫번째 요소임으로 head 와 tail 에 Node 저장
        if(head == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            //LinkedList 의 head 값이 null 아니면 n+1번째 요소임으로
            // newNode 의 next 에 현재 head 값 저장 , head 에 newNode 저장
            newNode.next = this.head;
            this.head = newNode;
        }
        size++;
        return newNode;
    }
    // 마지막 번째 에 new Node 를 추가하는 method;
    public Node add(int value){
        if(head ==null){
           return firstNodeAdd(value);
        }else {
            Node newNode = new Node(value);
            tail.next= newNode;
            tail=newNode;
            size++;
            return newNode;
        }
    }

    // 특정위치 에 new Node 를 추가하는 method;
    public Node add(int value, int position){
        Node newNode = new Node(value);
        if (position == 0){
            return firstNodeAdd(value);
        }else{
            Node node = node(position-1);
            Node temp = node.next;
            node.next = newNode;
            newNode.next=temp;
            if(newNode.next == null){
                this.tail=newNode;
            }
            size++;
        }
        return newNode;
    }
    // LinkedList 에 해당 요소가 존재하는지 확인하는 method;
    public boolean contains(Node checkNode){
        Node node = head;
        do{
            if(node ==checkNode){
                return true;
            }
            node = node.next;
        }while (head.next != null);
        return false;
    }

    // 특정위치에있는 요소 삭제.
    public Node remove(int position){
        if (position == 0) {
            Node node =node(position);
            this.head = node.next;
            size--;
            return node;
        }else {
            Node node = node(position-1);
            Node removeNode = node.next;
            node.next = removeNode.next;
            size--;
            return removeNode;
        }
    }

    // 특정위치에 있는 요소 반환하는 method
    private Node node(int position){
        Node node = head;
        for (int i = 0; i < position; i++) {
          node = node.next;
        }
        return node;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        if(head == null){
            return "[]";
        }
        Node temp = head;
        StringBuilder str = new StringBuilder("[");
        while(temp.next != null){
            str.append(temp.data).append(",");
            temp = temp.next;
        }
        str.append(temp.data);
        return str+"]";
    }
}
