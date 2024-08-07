package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int a = Integer.parseInt(inputArr[0]);
        int b = Integer.parseInt(inputArr[1]);

        int answer = 0;
        boolean isFound = false;
        Queue<Integer> queue = new LinkedList<>();
        int[] check = new int[100001];
        queue.add(a);
        check[a] = 1;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int target = queue.poll();
                if(target==b){
                    queue.clear();
                    isFound = true;
                    break;
                }
                int[] nexts = {target+1, target-1, target*2};
                for(int next : nexts){
                    if(next>=0 && next<=100000 && check[next]==0){
                        check[next] = 1;
                        queue.add(next);
                    }
                }
            }
            if(isFound) break;
            answer++;
        }
        System.out.println(answer);
    }
}
