package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class S2667 {
    static int[][] board;
    static int answer, area, n;
    static ArrayList<Integer> answerList;

    public static void DFS(int y, int x){
        area++;
        board[y][x] = 0;
        int[][] dis = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int i = 0; i < 4; i++) {
            int nextY = y + dis[i][0];
            int nextX = x + dis[i][1];
            if(nextX>=0 && nextX<n && nextY>=0 && nextY<n && board[nextY][nextX]==1){
                DFS(nextY, nextX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        answerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = Character.getNumericValue(arr[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==1){
                    answer++;
                    area = 0;
                    DFS(i, j);
                    answerList.add(area);
                }
            }
        }
        System.out.println(answer);
        Collections.sort(answerList);
        for (Integer i : answerList) {
            System.out.println(i);
        }
    }
}
