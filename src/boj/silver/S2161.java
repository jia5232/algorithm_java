package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.poll()).append(" ");
            if(!queue.isEmpty()){
                queue.add(queue.poll());
            }
        }
        System.out.println(sb);
    }
}
