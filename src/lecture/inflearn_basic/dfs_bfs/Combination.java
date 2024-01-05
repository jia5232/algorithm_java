package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination {
    static int n, m;
    static int[] combi;
    static int ch[];

    public static void DFS(int L, int s){
        if(L==m){
            StringBuilder sb = new StringBuilder();
            for (int i : combi) {
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
        else{
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi = new int[m];
        ch = new int[n+1];
        DFS(0, 1);
    }
}