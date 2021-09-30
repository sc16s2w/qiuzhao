package com.company.aftership;

import java.util.*;

public class Code_111 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for(int i = 0;i<length;i++){
            arr[i] = scanner.nextInt();
        }
        int[] left = count(length-1,0,arr);
        int[] right = count(0,length-1,arr);
        for(int i =0;i<length;i++){
            System.out.println(left[i]+" "+right[i]);
        }
    }
    public static int[] count(int start,int end,int[] arr){
        Stack<Integer> store = new Stack<>();
        store.add(start);
        int[] result = new int[arr.length];
        Arrays.fill(result,-1);
        if(start == arr.length-1){
            for(int i =start-1;i>=0;i--){
                if(arr[i]>=arr[store.peek()]){
                    store.add(i);
                }
                else if(arr[i]<arr[store.peek()]){
                    while(!store.isEmpty()&&arr[i]<arr[store.peek()]){
                        result[store.pop()] = i;
                    }
                    store.add(i);
                }
            }
        }
        else{
            for(int i =start+1;i<=end;i++){
                if(arr[i]>=arr[store.peek()]){
                    store.add(i);
                }
                else if(arr[i]<arr[store.peek()]){
                    while(!store.isEmpty()&&arr[i]<arr[store.peek()]){
                        result[store.pop()] = i;
                    }
                    store.add(i);
                }
            }

        }
        return result;
    }
    public String longestCommonPrefix (String[] strs) {
        // write code here
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length() - t1.length();
            }
        });
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].contains(result)) {
                continue;
            }
            int j = 0;
            for (; i < result.length(); j++) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            result = result.substring(0, j);
        }
        return result;
    }
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        Map<String,Integer> store = new HashMap<>();
        for(int i =0;i<strings.length;i++){
            if(store.containsKey(strings[i])) store.put(strings[i],store.get(strings[i])+1);
            else store.put(strings[i],1);
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(store.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> stringIntegerEntry, Map.Entry<String, Integer> t1) {
                if(t1.getValue()==stringIntegerEntry.getValue()) return t1.getKey().compareTo(stringIntegerEntry.getKey());
                return t1.getValue()-stringIntegerEntry.getValue();
            }
        });
        String[][] result = new String[k][2];
        int i = 0;
        for(Map.Entry<String,Integer> entry:list){
            if(i==k) break;
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue()+"";
            i++;
        }
        return result;
    }
}
