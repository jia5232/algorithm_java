package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pNum = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i <= pNum; i++) {
            arrayList.add(new ArrayList<>());
        }
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(1);
        for(int i=0; i<2; i++){
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int tmp = queue.poll();
                for(int k : arrayList.get(tmp)){
                    queue.add(k);
                    set.add(k);
                }
            }
        }
        set.remove(1);
        System.out.println(set.size());
    }
}
