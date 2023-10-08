package lecture.inflearn_basic.dfs_bfs;

import java.util.Scanner;

public class SubsetWithEqualSum {
    static String answer = "NO";
    static int n;
    static int total;
    static boolean flag = false;
    public static void DFS(int L, int sum, int[] arr){
        //flag = true이면 넘어오는 재귀는 그냥 리턴시켜버린다.
        if(flag) return;

        //부분집합의 총합이 절반보다 크면 그냥 리턴시킨다.
        if(sum > total/2) return;

        if(L==n){ //하나의 부분집합이 완성!
            if(total-sum == sum){
                answer = "YES";
                flag = true; //이제 더이상 재귀를 돌지 않는다.
            }
        }
        else{
            //i) L번째의 원소를 부분 집합에 사용하겠다.
            DFS(L+1, sum+arr[L], arr);
            //ii) L번째의 원소를 부분 집합에 사용하지 않겠다.
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        DFS(0, 0, arr);
        System.out.println(answer);
    }
}
