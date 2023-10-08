package lecture.inflearn_basic.dfs_bfs;

import java.util.Scanner;

public class Combination {
    static int[] combi;
    static int n, m;
    public static void DFS(int L, int s){
        if(L==m){
            for (int i : combi) System.out.print(i+" ");
            System.out.println();
        }
        else{
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
                //새롭게 고르는 수 s는 하나씩 뒤로 밀려야 하므로 i+1이 새로운 s가 된다.
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        DFS(0, 1);
    }
}
