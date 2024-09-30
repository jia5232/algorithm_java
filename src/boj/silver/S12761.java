package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S12761 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int a = Integer.parseInt(inputArr[0]);
        int b = Integer.parseInt(inputArr[1]);
        int n = Integer.parseInt(inputArr[2]);
        int m = Integer.parseInt(inputArr[3]);
        Queue<Integer> queue = new LinkedList<>();
        int[] ch = new int[100001];
        queue.add(n);
        ch[n] = 1;
        int answer = 0;
        boolean isFound = false;
        while (!queue.isEmpty()){
            if(isFound) break;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if(now==m){
                    isFound = true;
                    break;
                }

                if(now+1<=100000 && ch[now+1]==0){
                    ch[now+1] = 1;
                    queue.add(now+1);
                }
                if(now-1>=0 && ch[now-1]==0){
                    ch[now-1] = 1;
                    queue.add(now-1);
                }
                if(now+a<=100000 && ch[now+a]==0){
                    ch[now+a] = 1;
                    queue.add(now+a);
                }
                if(now-a>=0 && ch[now-a]==0){
                    ch[now-a] = 1;
                    queue.add(now-a);
                }
                if(now+b<=100000 && ch[now+b]==0){
                    ch[now+b] = 1;
                    queue.add(now+b);
                }
                if(now-b>=0 && ch[now-b]==0){
                    ch[now-b] = 1;
                    queue.add(now-b);
                }
                if(now*a<=100000 && ch[now*a]==0){
                    ch[now*a] = 1;
                    queue.add(now*a);
                }
                if(now*b<=100000 && ch[now*b]==0){
                    ch[now*b] = 1;
                    queue.add(now*b);
                }
            }
            if(!isFound) answer++;
        }
        System.out.println(answer);
    }
}
