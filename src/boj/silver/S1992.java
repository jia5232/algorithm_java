package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1992 {
    static StringBuilder sb = new StringBuilder();
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        quadTree(0, 0, n);
        System.out.println(sb);
    }

    public static void quadTree(int r, int c, int size){
        if(isAllSame(r, c, size)){
            sb.append(board[r][c]);
        } else {
            int newSize = size/2;
            sb.append("(");
            quadTree(r, c, newSize);
            quadTree(r, c+newSize, newSize);
            quadTree(r+newSize, c, newSize);
            quadTree(r+newSize, c+newSize, newSize);
            sb.append(")");
        }
    }

    public static boolean isAllSame(int r, int c, int size){
        int start = board[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(board[i][j]!=start) return false;
            }
        }
        return true;
    }
}