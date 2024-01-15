package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2580 {
    static int[][] board;

    public static void DFS(int r, int c){
        if(c==9){
            DFS(r+1, 0);
            return;
        }

        if(r==9){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(' ');
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(board[r][c]==0){
            for (int i = 1; i <= 9; i++) {
                if(check(r, c, i)){
                    board[r][c] = i;
                    DFS(r, c+1);
                }
            }
            board[r][c]=0; //??
            return;
        }
        DFS(r, c+1);
    }

    public static boolean check(int row, int col, int value){
        for (int i = 0; i < 9; i++) { //같은 행
            if(board[row][i]==value) return false;
        }

        for (int i = 0; i < 9; i++) { //같은 열
            if(board[i][col]==value) return false;
        }

        int row_start = (row/3) * 3;
        int col_start = (col/3) * 3;

        for (int i = row_start; i < row_start + 3; i++) { //같은 사각형
            for (int j = col_start; j < col_start + 3; j++) {
                if(board[i][j]==value) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);
    }
}
