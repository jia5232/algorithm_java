package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class G1987 {
    static char[][] board;
    static int[][] max;
    static Set<Character> record;
    static int row, col;

    static int[][] dis = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void DFS(int r, int c){
        for (int i = 0; i < 4; i++) {
            int nextR = r+dis[i][0];
            int nextC = c+dis[i][1];
            if(nextR>=0 && nextR<row && nextC>=0 && nextC<col && !record.contains(board[nextR][nextC])){
                record.add(board[nextR][nextC]);
                max[nextR][nextC] = max[r][c]+1;
                DFS(nextR, nextC);
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
        max = new int[row][col];
        record = new HashSet<>();
        for (int i = 0; i < row; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                board[i][j] = tmp[j];
            }
        }
        max[0][0] = 1;
        record.add(board[0][0]);
        DFS(0, 0);
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(max[i]));
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            maxValue = Math.max(maxValue, Arrays.stream(max[i]).max().getAsInt());
        }
        System.out.println(maxValue);
    }
}
