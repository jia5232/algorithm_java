package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S5014 {
    static int f, s, g, u, d, answer;

    static int[] check;

    public static String BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        check[s] = 1;
        while (!queue.isEmpty()){
            int now = queue.poll();

            if(now==g) return String.valueOf(check[now]-1);

            int nextU = now + u;
            if(nextU<=f && check[nextU]==0){
                check[nextU] = check[now]+1;
                queue.add(nextU);
            }

            int nextD = now - d;
            if(nextD>0 && check[nextD]==0){
                check[nextD] = check[now]+1;
                queue.add(nextD);
            }
        }
        return "use the stairs";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        answer = 0;
        check = new int[f+1];
        System.out.println(BFS());
    }
}
