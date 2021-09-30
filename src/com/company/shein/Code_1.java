package com.company.shein;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

   ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int k = scanner.nextInt();
        ListNode head = new ListNode();
        ListNode  p = new ListNode();
        head.next=p;
        for(int i=0;i<length;i++){
            ListNode temp = new ListNode(scanner.nextInt());
            p.next = temp;
            p = p.next;
        }
//        System.out.println(head.next.next.val);
        ListNode next = delete(head.next.next,length,k);
        StringBuilder sb = new StringBuilder();
        while(next!=null){
            sb.append(next.val);
            sb.append(" ");
            next = next.next;
        }
        sb.deleteCharAt(sb.length()-1);
//        System.out.println(sb.toString().equals("1 2 4 5"));
        System.out.println(sb.toString());
    }

    private static ListNode delete(ListNode next, int length, int k) {
        ListNode p = next;
        if(k==1) return next.next;
        while(k>2){
            p = p.next;
            k--;
        }
//        System.out.println(p.val);
        p.next = p.next.next;
        return next;

    }
}
