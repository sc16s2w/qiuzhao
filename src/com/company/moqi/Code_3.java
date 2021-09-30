package com.company.moqi;

import java.util.HashMap;
import java.util.Map;

public class Code_3 {
    public static int is_valid_citizen_id (String citizen_id) {
        // write code here
        String[] temp = citizen_id.split("");
        int[] input = new int[temp.length-1];
        for(int i = 0;i<temp.length-1;i++){
            input[i] = Integer.parseInt(temp[i]);
        }
        Map<Integer,String> store = new HashMap<>();
        store.put(0,"1");
        store.put(1,"0");
        store.put(2,"X");
        store.put(3,"9");
        store.put(4,"8");
        store.put(5,"7");
        store.put(6,"6");
        store.put(7,"5");
        store.put(8,"4");
        store.put(9,"3");
        store.put(10,"2");
        int[] index = new int[]{7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        int result = 0;
        for(int i = 0;i<input.length;i++){
            result+=input[i]*index[i];
        }
        result=result%11;
       if(temp[temp.length-1].equals(store.get(result))) return 1;
       return 0;


    }
    public static void main(String[] args){
        System.out.println(is_valid_citizen_id("511124199808270029"));
    }
}
