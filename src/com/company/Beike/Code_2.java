package com.company.Beike;

import java.util.Scanner;
import java.util.Stack;

public class Code_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int groupNum = scanner.nextInt();
        int[] result = new int[groupNum];
        for(int i = 0;i<groupNum;i++){
            int length = scanner.nextInt();
//            String hh = scanner.next();
//            System.out.println(hh);
            result[i] = operateNum(scanner.next());
        }
        for(int i = 0;i<groupNum;i++){
            System.out.println(result[i]);
        }
    }

    private static int operateNum(String next) {
        Stack<Character> store = new Stack<>();
        char[] ch = next.toCharArray();
        int count = 0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='('){
                store.add(')');
            }
            else{
                if(store.isEmpty()||store.peek()!=ch[i]){
                    count++;
                }
                else if(!store.isEmpty()&&store.peek()==ch[i]){
                    store.pop();
                }
            }
        }
        return count;
    }
}
