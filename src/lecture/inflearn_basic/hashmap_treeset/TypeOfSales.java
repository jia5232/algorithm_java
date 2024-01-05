package lecture.inflearn_basic.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class TypeOfSales {
    public static void solution(int n, int k, int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i], 1);
        }

        answer.add(map.keySet().size());

        for (int i = k; i < n; i++) {
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i], 1);

            if(map.get(arr[i-k])==1) map.remove(arr[i-k]);
            else map.put(arr[i-k], map.get(arr[i-k])-1);

            answer.add(map.keySet().size());
        }

        for (Integer i : answer) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        solution(n, k, arr);
    }
}