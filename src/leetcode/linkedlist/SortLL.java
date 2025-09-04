package leetcode.linkedlist;

public class SortLL {

    private Node head;
    private Node tail;

    public class Node{
        private int element;
        private Node next;

        public Node(int element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(int element) {
            this.element = element;
        }
    }

    public void insertLast(int element){
        Node node=new Node(element);
        Node temp=head;
        if(head==null) head=node;
        else{
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
            node.next=null;
        }
    }

    public void display(){
        Node temp=head;

        while (temp!=null){
            System.out.print(temp.element+"-->");
            temp=temp.next;
        }
        System.out.println("END");
    }


    public static void main(String[] args) {
        SortLL sortLL=new SortLL();
        sortLL.insertLast(3);
        sortLL.insertLast(2);
        sortLL.insertLast(6);
        sortLL.insertLast(10);
        sortLL.insertLast(101);
        sortLL.insertLast(-1);
        sortLL.display();
    }
}
