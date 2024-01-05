package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutation {
    static int n, m;
    static int[] arr, pm, ch;

    public static void DFS(int L){
        if(L==m){
            StringBuilder sb = new StringBuilder();
            for (int i : pm) {
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
        else{
            for (int i = 0; i < n; i++) {
                if(ch[i]==0){
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        pm = new int[m];
        ch = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        DFS(0);
    }
}