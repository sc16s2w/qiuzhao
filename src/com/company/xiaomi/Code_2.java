package com.company.xiaomi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Code_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(change(input));
    }

    private static String change(String input) {
        Map<String,Integer> store = new HashMap<>();
        String[] temp = input.split(" ");
        store.put("1",0);
        store.put("2",0);
        store.put("3",0);
        for(int i =0;i<temp.length;i++){
            if(temp[i].equals("1")) store.put("1",store.get("1")+1);
            else if(temp[i].equals("2")) store.put("2",store.get("2")+1);
            else store.put("3",store.get("3")+1);
        }
        String result = "";
        for(int i =0;i<store.get("1");i++){
            result+="1"+" ";
        }
        for(int i =0;i<store.get("2");i++){
            result+="2"+" ";
        }
        for(int i =0;i<store.get("3")-1;i++){
            result+="3"+" ";
        }
        result+="3";
        return result;
    }
}
