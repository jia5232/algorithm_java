package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S16956 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int r = Integer.parseInt(inputArr[0]);
        int c = Integer.parseInt(inputArr[1]);
        char[][] board = new char[r][c];
        for (int i = 0; i < r; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                board[i][j] = inputArr[j].charAt(0);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j]=='W'){
                    for (int k = 0; k < 4; k++) {
                        int nextR = i + dr[k];
                        int nextC = j + dc[k];
                        if(nextR>=0 && nextR<r && nextC>=0 && nextC<c){
                            if(board[nextR][nextC]=='S'){
                                System.out.println(0);
                                return; //늑대랑 양이 붙어있다면 프로그램 종료
                            } else if (board[nextR][nextC]=='.'){
                                board[nextR][nextC] = 'D';
                            }
                        }
                    }
                }
            }
        }

        //프로그램이 종료되지 않았다면 늑대를 막을 수 있다.
        System.out.println(1);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
