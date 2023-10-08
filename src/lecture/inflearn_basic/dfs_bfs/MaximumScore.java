package lecture.inflearn_basic.dfs_bfs;

import java.util.Scanner;

public class MaximumScore {
    static int num;
    static int maxTime;
    static int result = Integer.MIN_VALUE;
    public static void DFS(int L, int sumOfTime, int sumOfScore, int[][] arr){
        if(sumOfTime>maxTime) return;

        if(L==num){
            if(sumOfScore>result) result = sumOfScore;
        }
        else{
            //i) L번째의 원소를 부분집합에 사용
            DFS(L+1, sumOfTime+arr[L][1], sumOfScore+arr[L][0], arr);
            //ii) L번째의 원소를 부분집합에 사용하지 않음
            DFS(L+1, sumOfTime, sumOfScore, arr);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        maxTime = sc.nextInt();
        int[][] arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            arr[i][0] = sc.nextInt(); //점수
            arr[i][1] = sc.nextInt(); //소요시간
        }
        DFS(0, 0, 0, arr);
        System.out.println(result);
    }
}
