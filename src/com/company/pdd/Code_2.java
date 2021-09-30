package com.company.pdd;

import java.util.*;

public class Code_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> list = new ArrayList<>();
        while(num>0){
            list.add(scanner.next());
            num--;
        }
        List<String> result = dictionarySort(list);
        for(String s: result){
            System.out.println(s);
        }
    }

    private static List<String> dictionarySort(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                String sLarge = large(s);
                String t1Large = large(t1);
                String sSmall = small(s);
                String t1Small = small(t1);
                return compareS(sLarge,t1Large,sSmall,t1Small);
            }
        });
        return list;
    }

    private static int compareS(String sLarge, String t1Large, String sSmall, String t1Small){
        if(sSmall.compareTo(t1Large)==1){
            return 1;
        }
        else if(t1Small.compareTo(sLarge)==1){
            return -1;
        }
        else{
            return 1;
        }
    }
    private static String small(String s) {
        int i = 0;
        int j = s.length()-i-1;
        char[] ch = s.toCharArray();
        while(i<j){
            if(ch[i]>ch[j]){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j]=temp;
            }
            i++;
            j--;
        }
        return ch.toString();
    }

    private static String large(String s) {
        int i = 0;
        int j = s.length()-i-1;
        char[] ch = s.toCharArray();
        while(i<j){
            if(ch[i]<ch[j]){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j]=temp;
            }
            i++;
            j--;
        }
        return ch.toString();
    }
}
