package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class S2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(new int[]{i, Integer.parseInt(inputArr[i-1])});
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            int[] now = deque.pollFirst();
            sb.append(now[0]).append(" ");

            if(deque.isEmpty()) break;

            if(now[1] > 0) {
                for(int i = 0; i < now[1] - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for(int i = 0; i < Math.abs(now[1]); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        System.out.println(sb);
    }
}
