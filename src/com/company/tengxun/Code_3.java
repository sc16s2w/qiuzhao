package com.company.tengxun;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
public class Code_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int res = calculate(input);
        System.out.println(res);
    }

    private static boolean isOperation(String s){
        if(s.equals("@")||s.equals("+")||s.equals("x")){
            return true;
        }
        return false;
    }
    private static int calculate(String input) {
        Deque<String> store1 = new LinkedList<>();
        String[] inputTemp = input.split("");
        int i = 0;
        while (i < inputTemp.length) {
            if (isOperation(inputTemp[i])) {
                store1.add(inputTemp[i]);
                i++;
            } else {
                int t = i;
                int num1 = 0;
                while (t< inputTemp.length&&!isOperation(inputTemp[t])) {
                    t++;
                }
                int r = i;
                while (r< inputTemp.length&&!isOperation(inputTemp[r])) {
                    num1 += Math.pow(10, t - r-1) * Integer.parseInt(inputTemp[r]);
                    r++;
                    i++;
                }
                store1.add(num1 + "");
            }
        }
        int size =store1.size();
        while (size>0&&store1.contains("@")) {
            if (!store1.peek().equals("@")) {
                store1.addLast(store1.pop());
            } else {
                store1.pop();
                int num1 = Integer.parseInt(store1.getFirst());
                int num2 = Integer.parseInt(store1.getLast());
                int temp = num1 | (num1 + num2);
                store1.addFirst(temp + "");
            }
            size--;
        }
        size =store1.size();
        while (size>0&&store1.contains("x")) {
            if (!store1.peek().equals("x")) {
                store1.addLast(store1.pop());
            } else {
                store1.pop();
                int num1 = Integer.parseInt(store1.getFirst());
                int num2 = Integer.parseInt(store1.getLast());
                int temp = num1 * num2;
                store1.addFirst(temp + "");
            }
            size--;
        }
        int res = 0;
        size =store1.size();
        while (size>0&&store1.contains("+")) {
            if (!store1.peek().equals("x")) {
                store1.addLast(store1.pop());
            } else {
                store1.pop();
                int num1 = Integer.parseInt(store1.getFirst());
                int num2 = Integer.parseInt(store1.getLast());
                int temp = num1 + num2;
                store1.addFirst(temp + "");
            }
        }
        return Integer.parseInt(store1.pop());
    }
}
