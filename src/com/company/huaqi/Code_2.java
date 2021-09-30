package com.company.huaqi;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Code_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        List<String> result = caseTransform(s);
        String finalResult = "";
        for(String str:result){
           finalResult = finalResult+str+" ";
        }
        finalResult = finalResult.substring(0,finalResult.length()-1);
//        String hh= "PascalCaseTest pascalCaseTest pascal_case_test pascal-case-test";
//        System.out.println(hh);
//        System.out.println(hh.length());
//        System.out.println(finalResult.length());
        System.out.println(finalResult);
//        System.out.println(hh.equals(finalResult));

    }
    public static List<String> caseTransform(String s){
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        if(s.contains("_")){
            String[] ct = s.split("_");
            String cur = "";
            for(int i = 0;i<ct.length;i++){
                String tu = ct[i];
                String t = ct[i].toUpperCase();
                t = t.substring(0,1)+tu.substring(1,tu.length());
                cur+=t;
            }
            result.add(cur);
            cur = "";
            cur+=ct[0];
            for(int i = 1;i<ct.length;i++){
                String tu = ct[i];
                String t = ct[i].toUpperCase();
                t = t.substring(0,1)+tu.substring(1,tu.length());
                cur+=t;
            }
            result.add(cur);
            result.add(s);
            cur = "";
            for(int i = 0;i<ct.length-1;i++){
                cur+=ct[i]+"-";
            }
            cur+=ct[ct.length-1];
            result.add(cur);
        }
        else if(s.contains("-")){
            String[] ct = s.split("-");
            String cur = "";
            for(int i = 0;i<ct.length;i++){
                String tu = ct[i];
                String t = ct[i].toUpperCase();
                t = t.substring(0,1)+tu.substring(1,tu.length());
                cur+=t;
            }
            result.add(cur);
            cur = "";
            cur+=ct[0];
            for(int i = 1;i<ct.length;i++){
                String tu = ct[i];
                String t = ct[i].toUpperCase();
                t = t.substring(0,1)+tu.substring(1,tu.length());
                cur+=t;
            }
            result.add(cur);
            cur = "";
            for(int i = 0;i<ct.length-1;i++){
                cur+=ct[i]+"_";
            }
            cur+=ct[ct.length-1];
            result.add(cur);
            result.add(s);
        }
        else if(s.charAt(0)>='a'){
            for(int i = 0;i<ch.length;i++){
                if(ch[i]<'a'){
                    if(sb.length()>0) temp.add(sb.toString());
                    sb = new StringBuilder();
                }
                sb.append(ch[i]);
            }
            temp.add(sb.toString());
            String u = temp.get(0);
            String t = temp.get(0).toUpperCase();
            String cur = t.substring(0,1)+u.substring(1,u.length());
            for(int i = 1;i<temp.size();i++){
                cur+= temp.get(i);
            }
            result.add(cur);
            result.add(s);
            cur="";
            for(int i = 0;i<temp.size()-1;i++){
                cur=cur+temp.get(i).toLowerCase()+"_";
            }
            cur= cur+temp.get(temp.size()-1).toLowerCase();
            result.add(cur);
            cur="";
            for(int i = 0;i<temp.size()-1;i++){
                cur=cur+temp.get(i).toLowerCase()+"-";
            }
            cur+= temp.get(temp.size()-1).toLowerCase();
            result.add(cur);
        }
        else{
            result.add(s);
            for(int i = 0;i<ch.length;i++){
                if(ch[i]<'a'){
                    if(sb.length()>0) temp.add(sb.toString());
                    sb = new StringBuilder();
                }
                sb.append(ch[i]);
            }
            temp.add(sb.toString());
            String cur = temp.get(0).toLowerCase();
            for(int i = 1;i<temp.size();i++){
                cur+= temp.get(i);
            }
            result.add(cur);
            cur="";
            for(int i = 0;i<temp.size()-1;i++){
                cur=cur+temp.get(i).toLowerCase()+"_";
            }
            cur= cur+temp.get(temp.size()-1).toLowerCase();
            result.add(cur);
            cur="";
            for(int i = 0;i<temp.size()-1;i++){
                cur=cur+temp.get(i).toLowerCase()+"-";
            }
            cur+= temp.get(temp.size()-1).toLowerCase();
            result.add(cur);
        }
        return result;

    }
}
