package com.company.baidu;

import java.util.Scanner;

public class Code_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupNum = scanner.nextInt();
        String[] input = new String[groupNum];
        for (int i = 0; i < groupNum; i++) {
            input[i] = scanner.next();
        }
        for (int i = 0; i < groupNum; i++) {
            System.out.println(calculate(isFull(input[i])));
        }
    }

    private static String isFull(String str) {
       String[] input = str.split("");
       if(judge(input)) return str;
        String result = "";
        int carrier = 0;
       for(int i = input.length-1;i>=0;i--){
           if(carrier==0&&(input[i].equals("1")||input[i].equals("2")||input[i].equals("3"))){
//               System.out.println(result);
               carrier=0;
               result+='3';
               continue;
           }
//           System.out.println(Integer.parseInt(input[i]));
           if((Integer.parseInt(input[i])-carrier)>3){
               carrier=0;
               result+="3";
           }
           else if(Integer.parseInt(input[i])-carrier<=0){
               if(i==0) break;
               carrier = 1;
               result+="3";
           }
           if(i>0&&input[i].equals("0")){
               carrier=1;
           }
       }
       String reverseResult = "";
       for(int i = result.length()-1;i>=0;i--){
           reverseResult+=result.charAt(i);
       }

       return reverseResult;
    }
    public static boolean judge(String[] input){
        for(int i = 0;i< input.length;i++){
            if(input[i].equals("1")||input[i].equals("2")||input[i].equals("3")){
                continue;
            }
            else return false;
        }
        return true;
    }
    public static long calculate(String s){
        long result = 0;
        for(int i = 0;i < s.length();i++){
            String temp = s.charAt(i)+"";
            result+=Integer.parseInt(temp)*Math.pow(10,s.length()-i-1);
        }
        return result;
    }

}
