package lecture.inflearn_basic.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subset {
    static int[] ch;

    public static void DFS(int n, int L){
        if(L==n+1){
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if(ch[i]==1) sb.append(i).append(" ");
            }
            System.out.println(sb);
        } else {
            ch[L] = 1;
            DFS(n, L+1);

            ch[L] = 0;
            DFS(n, L+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ch = new int[num+1];
        DFS(num, 1);
    }
}