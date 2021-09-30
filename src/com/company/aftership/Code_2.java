package com.company.aftership;

import java.util.Scanner;

public class Code_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num<1) System.out.println(0);
        if(num==1) System.out.println(1);
        if(num==2) System.out.println(2);
        int n1 = 1;
        int n2 = 2;
        int n = 0;
        for(int i = 3;i<=num;i++){
            n= (int) ((n1+n2)%Math.pow(2,29));
            n1=n2;
            n2 = n;
        }
        System.out.println(n);

    }
}
