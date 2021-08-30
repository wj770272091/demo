package com.example.demo;

/**
 * @author 77027
 * @NAME: ListlinkTest
 * @USER: 77027
 * @DATE: 2020/11/30
 * @TIME: 11:06
 */
public class ListlinkTest {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
public static boolean isCycle(Node head){
        Node p1=head;
        Node p2=head;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        if (p1==p2){
            return true;
        }
        }
        return false;
}

    public static void main(String[] args) {
        Node node1=new Node(5);
        Node node2=new Node(3);
        Node node3=new Node(7);
        Node node4=new Node(2);
        Node node5=new Node(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
//        node5.next=node2;
        System.out.println(isCycle(node1));
    }
}
