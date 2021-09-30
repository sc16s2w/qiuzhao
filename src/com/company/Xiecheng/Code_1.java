package com.company.Xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Code_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Stack<String> store = new Stack<>();
        String sh = scanner.nextLine();
        for(int i=0;i<num;i++){
            List<String> storeTemp = new ArrayList<>();
            String input = scanner.nextLine();
            String[] temp = input.split("");
            String str1 = temp[0]+temp[1];
            if(str1.equals("cd")){
//                System.out.println(".");
                if(temp[3].equals(".")){
                    if(!store.isEmpty()){
//                        System.out.println(store.peek());
//                        System.out.println("来了");
                        store.pop();
                    }
                }
                else{
                    String str = "";
                    for(int j=3;j<temp.length;j++){
                        str+=temp[j];
                    }
                    store.add(str);
//                    System.out.println(str);
                }
            }
            else{
                if(store.isEmpty()){
                    System.out.println("\\");
                }
                else{
                    String[] s = new String[store.size()];
                    int length = store.size()-1;
                    while(!store.isEmpty()){
                        storeTemp.add(store.peek());
//                        System.out.println(store.peek());
                        s[length] = "\\"+store.pop();
                        length--;
                    }
                    for(int j = storeTemp.size()-1;j>=0;j--){
                        store.add(storeTemp.get(j));
                    }
                    String result = "";
                    for(int j = 0;j<s.length;j++){
                        result+=s[j];
                    }
                    System.out.println(result);
                }
            }
        }
    }
}
