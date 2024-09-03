package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class S14889 {
    static int n;
    static int[][] board;
    static int[] combi, check;
    static int min = Integer.MAX_VALUE;

    public static void DFS(int idx, int count){
        if(count==n/2){
            int startScore = 0;
            int linkScore = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if(check[i]==1 && check[j]==1){
                        startScore += board[i][j];
                        startScore += board[j][i];
                    } else if(check[i]==0 && check[j]==0){
                        linkScore += board[i][j];
                        linkScore += board[j][i];
                    }
                }
            }

            min = Math.min(min, Math.abs(startScore-linkScore));
            return;
        }else{
            for (int i = idx; i < n; i++) {
                if(check[i]==0){
                    check[i] = 1;
                    DFS(i+1, count+1);
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        combi = new int[n/2];
        check = new int[n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        DFS(0, 0);
        System.out.println(min);
    }
}
