package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S14248 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        int[] bridges = new int[n];
        for (int i = 0; i < n; i++) {
            bridges[i] = Integer.parseInt(inputArr[i]);
        }
        int[] ch = new int[n];
        int s = Integer.parseInt(br.readLine())-1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        ch[s] = 1;
        int answer = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                int tmp = bridges[now];
                if(now+tmp<n && ch[now+tmp]==0){
                    ch[now+tmp] = 1;
                    queue.add(now+tmp);
                    answer++;
                }
                if(now-tmp>=0 && ch[now-tmp]==0){
                    ch[now-tmp] = 1;
                    queue.add(now-tmp);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
