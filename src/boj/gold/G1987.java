package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class G1987 {
    static char[][] board;
    static Set<Character> record;
    static int row, col;
    static int result;
    static int[][] dis = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void DFS(int r, int c, int sum){
        result = Math.max(sum, result);
        for (int i = 0; i < 4; i++) {
            int nextR = r+dis[i][0];
            int nextC = c+dis[i][1];
            if(nextR>=0 && nextR<row && nextC>=0 && nextC<col && !record.contains(board[nextR][nextC])){
                record.add(board[nextR][nextC]);
                DFS(nextR, nextC, sum+1);
                record.remove(board[nextR][nextC]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        board = new char[row][col];
        record = new HashSet<>();
        for (int i = 0; i < row; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                board[i][j] = tmp[j];
            }
        }
        result = 0;
        record.add(board[0][0]);
        DFS(0, 0, 1);

        System.out.println(result);
    }
}
