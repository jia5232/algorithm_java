package lecture.inflearn_basic.dfs_bfs;

import java.util.Scanner;

public class Permutation {
    static int n, m;
    static int[] pm; //순열의 결과
    static int[] ch; //사용여부 체크
    static int[] arr; //입력된 N개의 자연수 배열

    public static void DFS(int L){
        if(L==m){
            for (int i : pm) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        else{
            for (int i = 0; i < n; i++) {
                if(ch[i]==0){
                    ch[i] = 1; //체크 걸고
                    pm[L] = arr[i];
                    DFS(L+1); //돌리고
                    ch[i] = 0; //체크 풀고
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        ch = new int[n];
        pm = new int[m];
        DFS(0);
    }
}
