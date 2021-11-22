package linkedLists;
//This is creation of a Linked List from scratch

public class LL {

    //All below are set to private coz I don't want them to be altered from the outside
    private Node head;
    private Node tail;

    private int size;


    //A constructor when LL created
    public LL(){
        this.size=0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        //When this is the first item
        if(tail==null){
            tail = head;
        }
        size+=1;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size+=1;

    }

    public void insert(int val, int index){

        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp = head;

        for (int i = 1; i < index ; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
    }

    public void delete(int index){
        Node temp = head;

        for (int i = 1; i < index ; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        size--;

    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + "-> ");
            temp = temp.next;
        }
        System.out.print("NULL");

    }

    private class Node{

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
