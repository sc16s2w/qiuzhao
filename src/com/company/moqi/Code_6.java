package com.company.moqi;

public class Code_6 {

    public static void main(String[] args) {

//		int[][] arr = {{1,2,-3},{3,4,-5},{-5,-6,-7}};//3
        int[][] arr = {{}};

        System.out.println("ans= "+sumOfSubMatrix(arr, arr.length));
    }

    public static int sumOfSubMatrix(int[][] mat, int n) {

        int sum = Integer.MIN_VALUE;;
        int pre=0;
        int[] tempArr = new int [mat[0].length];
        for(int i=0;i<mat.length;i++){//第i行
            pre=0;
            for(int x=0;x<mat[0].length;x++){
                tempArr[x] = mat[i][x];
                pre = Math.max(pre+tempArr[x], tempArr[x]);
                sum = Math.max(sum, pre);
            }
            System.out.println(sum);

            for(int j=i+1;j<mat[0].length;j++){//第j行
                pre=0;
                for(int x=0;x<mat[0].length;x++){
                    tempArr[x] += mat[j][x];
                    pre = Math.max(pre+tempArr[x], tempArr[x]);
                    sum = Math.max(sum, pre);
                }
                System.out.println(sum);
            }
        }
        return sum;
    }
}
