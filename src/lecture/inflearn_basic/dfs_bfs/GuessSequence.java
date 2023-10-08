package lecture.inflearn_basic.dfs_bfs;

import java.util.Scanner;

public class GuessSequence {
    static int[] b; //Combination값들 저장
    static int[] p; //순열 저장
    static int[] ch; //중복이 아니므로 체크값 저장.
    static int n, f;
    static boolean flag = false;
    static int[][] dy = new int[35][35];
    public static int combi(int n, int r){
        if(dy[n][r]>0) return dy[n][r];

        if(n==r || r==0) return 1;
        else return dy[n][r] = combi(n-1, r-1)+combi(n-1, r);
    }

    public static void DFS(int L, int sum){
        if(flag) return;
        if(L==n){
            if(sum==f){
                for (int i : p) System.out.print(i+" ");
                flag = true;
            }

        }
        else{
            for (int i = 1; i <= n; i++) { //i가 인덱스가 아니라 수열을 구성하는 숫자 그 자체!
                if(ch[i]==0){
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L+1, sum+(p[L]*b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n+1]; //인덱스가 아니라 실제 값으로 체크하기 위해서 n+1로 설정
        for (int i = 0; i < n; i++) {
            b[i] = combi(n-1, i);
        }
        DFS(0, 0);
    }
}
