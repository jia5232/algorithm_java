package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1189 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] arr;
    static int[][] check;
    static int r, c, k, answer = 0;

    public static void DFS(int L, int row, int col){
        if(L==k && row==0 && col==c-1){
            answer++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextR = row + dy[i];
            int nextC = col + dx[i];
            if(nextR>=0 && nextR<r && nextC>=0 && nextC<c && arr[nextR][nextC]=='.' && check[nextR][nextC]==0){
                check[nextR][nextC] = 1;
                DFS(L+1, nextR, nextC);
                check[nextR][nextC] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        r = Integer.parseInt(inputArr[0]);
        c = Integer.parseInt(inputArr[1]);
        k = Integer.parseInt(inputArr[2]);
        arr = new char[r][c];
        check = new int[r][c];
        for (int i = 0; i < r; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = inputArr[j].charAt(0);
            }
        }
        check[r-1][0] = 1;
        DFS(1, r-1, 0);
        System.out.println(answer);
    }
}
