package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public Node solution(){
        List<Integer> list=new ArrayList<>();
        Node temp=head;
        int max=-1000;
        int min=10000;

        while (temp!=null){
            min=Math.min(max,temp.element);
            max=Math.max(max,temp.element);
            list.add(temp.element);
            temp=temp.next;
        }
        int []counting=cyclicSort(list,max,min);

        temp=head;

        for(int i=0;i<counting.length;i++){
            while (counting[i]>0){
                temp.element= i+min;
                counting[i]--;
                temp=temp.next;
            }
        }


//        int idx=0;
//
//        while (temp!=null){
//            temp.element=list.get(idx++);
//            temp=temp.next;
//        }

        return head;
    }

    static int[] cyclicSort(List<Integer> list,int maxValue,int minValue){
        int []map=new int[maxValue-minValue+1];
        for(int i:list){
            map[i-minValue]++;
        }

//        System.out.println(Arrays.toString(map));
        return map;
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
        sortLL.solution();
        sortLL.display();
    }
}
