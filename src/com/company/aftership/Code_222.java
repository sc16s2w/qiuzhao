package com.company.aftership;

import java.util.Scanner;

public class Code_222 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n<3) System.out.println(n);
        double numZero = 1;
        double numOne = 2;
        double mod = Math.pow(2,29);
        double result = 0.0;
        for(int i =3;i<=n;i++){
            result = (numOne+numZero)%mod;
            numZero = numOne;
            numOne = result;
        }
        System.out.println((int)result);
    }
}
