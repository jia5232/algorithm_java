package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutation {
    static int n, m;
    static int[] arr, pm, ch;

    public static void DFS(int L){
        if(L==m){
            StringBuilder sb = new StringBuilder();
            for(int i : pm){
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        } else {
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

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        inputArr = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        ch = new int[n];
        pm = new int[m];
        DFS(0);
    }
}