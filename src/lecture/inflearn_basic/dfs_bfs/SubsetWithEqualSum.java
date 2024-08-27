package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubsetWithEqualSum {
    static int n;
    static int[] arr;
    static boolean answer;
    static int arrSum;

    public static void DFS(int L, int sum){
        if(answer) return;
        if(sum>arrSum/2) return;

        if(L==n){
            if(sum*2==arrSum){
                answer = true;
            }
            return;
        }
        DFS(L+1, sum+arr[L]);
        DFS(L+1, sum);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        arr = new int[n];
        answer = false;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        arrSum = Arrays.stream(arr).sum();
        DFS(0, 0);
        if(answer) System.out.println("YES");
        else System.out.println("NO");
    }
}