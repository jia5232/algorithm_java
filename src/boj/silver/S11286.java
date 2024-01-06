package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if(firstAbs==secondAbs) return o1 > o2 ? 1 : -1;
            else return firstAbs-secondAbs; //절댓값 기준 오름차순 정렬
        });
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(pQ.isEmpty()) sb.append(0+"\n");
                else sb.append(pQ.poll()+"\n");
            }
            else pQ.add(num);
        }
        System.out.println(sb);
    }
}
