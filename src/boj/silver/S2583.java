package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S2583 {
    static int[][] board;
    static int answer;
    static ArrayList<Integer> answerList;
    static int m, n;
    static int tmp;

    public static void DFS(int y, int x){
        //방문처리 + 넓이 구하기를 DFS안에 들어와서 해줘야한다..
        tmp++;
        board[y][x] = 1;

        int[][] dis = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int i = 0; i < 4; i++) {
            int nextY = y+dis[i][0];
            int nextX = x+dis[i][1];
            if(nextY>=0 && nextY<m && nextX>=0 && nextX<n && board[nextY][nextX]==0){
                DFS(nextY, nextX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    board[j][l] = 1;
                }
            }
        }
        answer = 0;
        answerList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==0){
                    answer++;
                    tmp = 0;
                    DFS(i, j);
                    answerList.add(tmp);
                }
            }
        }

        System.out.println(answer);
        Collections.sort(answerList);
        for (Integer i : answerList) {
            System.out.print(i+" ");
        }
    }
}
