package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class S2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        String[] inputArr;
        for(int i=0; i<n; i++){
            inputArr = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                pq.offer(Integer.parseInt(inputArr[j]));
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            answer = pq.poll();
        }
        System.out.println(answer);
    }
}
