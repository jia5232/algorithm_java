package lecture.inflearn_basic.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class TypeOfSales {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int k = Integer.parseInt(inputArr[1]);
        inputArr = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(inputArr[i]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int tmp = arr[i];
            if(map.containsKey(tmp)) map.put(tmp, map.get(tmp)+1);
            else map.put(tmp, 1);
        }
        System.out.print(map.keySet().size()+" ");
        for (int i = k; i < n; i++) {
            int plus = arr[i];
            int minus = arr[i-k];

            if(map.containsKey(plus)) map.put(plus, map.get(plus)+1);
            else map.put(plus, 1);

            if(map.containsKey(minus)){
                if(map.get(minus)==1) map.remove(minus);
                else map.put(minus, map.get(minus)-1);
            }

            System.out.print(map.keySet().size()+" ");
        }
    }
}