package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1780 {
    static int negative, zero, positive;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        checkPaper(0, 0, n);
        System.out.println(negative);
        System.out.println(zero);
        System.out.println(positive);
    }

    public static void checkPaper(int r, int c, int size){
        if(isPossible(r, c, size)){
            int paperNUm = board[r][c];
            if(paperNUm==-1) negative++;
            else if(paperNUm==0) zero++;
            else positive++;
        } else {
            int newSize = size/3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    checkPaper(r+(i*newSize), c+(j*newSize), newSize);
                }
            }
        }
    }

    public static boolean isPossible(int r, int c, int size){
        int start = board[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(board[i][j]!=start) return false;
            }
        }

        return true;
    }
}
