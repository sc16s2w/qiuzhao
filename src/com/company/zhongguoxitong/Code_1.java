package com.company.zhongguoxitong;

public class Code_1 {
    public String solve (String str) {
        // write code here
        String res  = "";
        for(int i =str.length()-1;i>=0;i--){
            res+=str.charAt(i);
        }
        return res;
    }
}
