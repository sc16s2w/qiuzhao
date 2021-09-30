package com.company.futu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_1 {
    public static class Node{
        int x;
        int y;
        int sum;
        public Node(int x,int y,int sum){
            this.x= x;
            this.y=y;
            this.sum=sum;
        }
    }
    public static void main(String[] args){
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{3,5,7,9,11};
        findTopKinTwoSortedArray(arr1,arr2,4);

    }
    public static class Max implements Comparator<Node>{
        @Override
        public int compare(Node node, Node t1) {
            return t1.sum-node.sum;
        }
    }
    public static int[] findTopKinTwoSortedArray (int[] arr1, int[] arr2, int k) {
        // write code here
        if(arr1==null||arr2==null||k<1) return null;
        k = Math.min(k,arr1.length*arr2.length);
        PriorityQueue<Node> store = new PriorityQueue<>(new Max());
        int index = 0;
        int i = arr1.length-1;
        int j = arr2.length-1;
        int[] result = new int[k];

        store.add(new Node(i,j,arr1[i]+arr2[j]));

        while(index!=k){
            Node cur = store.poll();
            if(cur==null) break;
            result[index]=cur.sum;
            i = cur.x;
            j = cur.y;
            if(i-1>=0){

                store.add(new Node(i-1,j,arr1[i-1]+arr2[j]));
            }
            if(j-1>=0){

                store.add(new Node(i,j-1,arr1[i]+arr2[j-1]));
            }
            index++;
        }
        for(int o=0;o<result.length;o++){
            System.out.println(result[o]);
        }
        Arrays.sort(result);
        int[] finalRes = new int[result.length];
        for(i=0;i<result.length;i++){
            finalRes[result.length-i-1] = result[i];
        }
        return finalRes;

    }
}

