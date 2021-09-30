package com.company.huawei;

import java.util.*;

public class Code_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int avg = scanner.nextInt();
        int n = scanner.nextInt();
        int[] input = new int[2*n];
        int sum = 0;
        for(int i =0;i<input.length;i++){
            input[i] = scanner.nextInt();
            sum+=input[i];

        }
        Arrays.sort(input);
        if(sum%avg==0){
            String res = calculate(avg,input); //
            System.out.println(res);
        }
        else System.out.println(0);
//        String res = calculate(avg,input);
//        System.out.println(res);

    }

    private static String calculate(int avg, int[] input) {
        Map<Integer, List<Integer>> res = new HashMap<>();
        Map<Integer, Boolean> used = new HashMap<>();
        Arrays.sort(input);
        for(int i = 0;i<input.length;i++){
            used.put(input[i],false);
            int temp = 0;
            if(input[i]<0){
                temp =(input[i]%avg+avg)%avg;
            }
            else {
                temp = input[i]%avg;
            }
            if(res.containsKey(temp)){
                List<Integer> store = res.get(temp);
                store.add(input[i]);
                res.put(temp,store);
            }
            else{
                List<Integer> store = new ArrayList<>();
                store.add(input[i]);
                res.put(temp,store);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<input.length;i++){
            if(used.get(input[i])) continue;
            used.put(input[i],true);
            int temp = 0;
            if(input[i]<0){
                temp =(input[i]%avg+avg)%avg;
            }
            else {
                temp = input[i]%avg;
            }
            List<Integer> time = new ArrayList<>();
            if(temp==0){
                if(!res.containsKey(temp)) return "0";
                List<Integer> store = res.get(temp);
                Collections.sort(store);
                int m;
                for(m = 0;m<store.size();m++){
                    if(!used.get(store.get(m))){
                        time.add(store.get(m));
                       break;
                    }
                }
                time.add(store.get(m));
                used.put(store.get(m),true);
                time.add(input[i]);
            }
            else{
//                System.out.println(avg-temp);
                if(!res.containsKey(avg-temp)) return "0";
                List<Integer> store = res.get(avg-temp);
                Collections.sort(store);
                int m;
                for(m = 0;m<store.size();m++){
                    if(!used.get(store.get(m))){
                        time.add(store.get(m));
                        break;
                    }
                }
                used.put(store.get(m),true);
                time.add(input[i]);
            }
            result.add(time);
        }
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> integers, List<Integer> t1) {
                if((integers.get(0)+integers.get(1)) == (t1.get(0)+t1.get(1)))
                    return Collections.max(t1)-Collections.max(integers);
                return  (t1.get(0)+t1.get(1))-(integers.get(0)+integers.get(1));
            }
        });

        String re = "";
        for(int i = 0;i<result.size()-1;i++){
            List<Integer> store = result.get(i);
            Collections.sort(store);
            re+=store.get(1)+" ";
            re+=store.get(0)+" ";
        }
        List<Integer> store = result.get(result.size()-1);
        Collections.sort(store);
        re+=store.get(1)+" ";
        re+=store.get(0);
        return re;
    }

}
