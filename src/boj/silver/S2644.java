package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        int a = Integer.parseInt(inputArr[0]);
        int b = Integer.parseInt(inputArr[1]);
        List<ArrayList<Integer>> array = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            array.add(new ArrayList<>());
        }
        int[] check = new int[n+1];

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            inputArr = br.readLine().split(" ");
            int p1 = Integer.parseInt(inputArr[0]);
            int p2 = Integer.parseInt(inputArr[1]);
            array.get(p1).add(p2);
            array.get(p2).add(p1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        check[a] = 1;
        int answer = 0;
        boolean isFound = false;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int target = queue.poll();
                if(target==b){
                    isFound = true;
                    queue.clear();
                    break;
                }

                for(int k : array.get(target)){
                    if(check[k]==0){
                        queue.add(k);
                        check[k] = 1;
                    }
                }
            }

            if(isFound) break;
            answer++;
        }

        if(isFound) System.out.println(answer);
        else System.out.println(-1);
    }
}
