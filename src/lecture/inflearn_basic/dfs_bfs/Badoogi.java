package lecture.inflearn_basic.dfs_bfs;

import java.util.Scanner;

public class Badoogi {
    static int max;
    static int n;
    static int result = Integer.MIN_VALUE;

    public static void DFS(int L, int sum, int[] arr){
        if(sum>max) return;

        if(L==n){
            if(sum>result) result = sum;
        }
        else{
            //i) L번째의 원소를 부분집합에 사용
            DFS(L+1, sum+arr[L], arr);
            //ii) L번째의 원소를 부분집합에 사용하지 않음
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0, 0, arr);
        System.out.println(result);
    }
}
