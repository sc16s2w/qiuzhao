package com.company.duxiaoman;

import java.util.*;

public class Code_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        String[] input = new String[m + n];
        for (int i = 0; i < (m + n); i++) {
            input[i] = scanner.next();
        }
        List<double[]> store = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            double[] temp = new double[2];
            String[] s = input[i].split("-");
            for (int t = 0; t < 2; t++) {
                String res = "";
                for (int j = 0; j < s[t].length(); j++) {
                    if (j == 0 && s[t].charAt(j) == '0') {
                        continue;
                    } else if (s[t].charAt(j) == ':') {
                        res += ".";
                    } else {
                        res += s[t].charAt(j);
                    }
                }
                temp[t] = Double.parseDouble(res);
            }
//            System.out.println(temp[0] + " " + temp[1]);
            store.add(temp);
        }
        int res = calculate(store);
        System.out.println(res);
    }

    private static int calculate(List<double[]> store) {
        Collections.sort(store, new Comparator<double[]>() {
            @Override
            public int compare(double[] doubles, double[] t1) {
                if(doubles[0]==t1[0]){
                    return (int) (doubles[1]-t1[1]);
                }
                return (int) (doubles[0]-t1[0]);
            }
        });
        int res = 1;
        double left = store.get(0)[0];
        double right = store.get(0)[1];
        for(int i =1;i<store.size();i++){
            System.out.println(store.get(i)[0]+" "+store.get(i)[1]);
            if(store.get(i)[0]>=right){
                res++;
                left = store.get(i)[0];
                right = store.get(i)[1];
            }
        }
        return res;
    }
}
