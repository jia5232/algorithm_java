package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G4179 { //다시풀기!!!
    static int r, c;
    static char[][] board;
    static Queue<int[]> fire = new LinkedList<>();
    static Queue<int[]> jihun = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        r = Integer.parseInt(inputArr[0]);
        c = Integer.parseInt(inputArr[1]);
        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                board[i][j] = inputArr[j].charAt(0);
                if(board[i][j]=='J'){
                    jihun.add(new int[]{i, j, 0});
                }
                if(board[i][j]=='F'){
                    fire.add(new int[]{i, j, 0});
                }
            }
        }

        int result = escape(fire, jihun);
        System.out.println(result==-1 ? "IMPOSSIBL" : result);
    }

    public static int escape(Queue<int[]> fire, Queue<int[]> jihun){
        int[][] fireDist = new int[r][c];
        int[][] jihunDist = new int[r][c];

        // 불의 확산 시간 계산
        while (!fire.isEmpty()) {
            int[] current = fire.poll();
            int x = current[0], y = current[1], time = current[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (board[nx][ny] == '#' || fireDist[nx][ny] > 0) continue;

                fireDist[nx][ny] = time + 1;
                fire.add(new int[]{nx, ny, time + 1});
            }
        }

        // 지훈이의 이동
        while (!jihun.isEmpty()) {
            int[] current = jihun.poll();
            int x = current[0], y = current[1], time = current[2];

            // 가장자리에 도달했는지 확인
            if (x == 0 || x == r - 1 || y == 0 || y == c - 1) {
                return time + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (board[nx][ny] == '#' || jihunDist[nx][ny] > 0) continue;
                if (fireDist[nx][ny] != 0 && fireDist[nx][ny] <= time + 1) continue;

                jihunDist[nx][ny] = time + 1;
                jihun.add(new int[]{nx, ny, time + 1});
            }
        }

        return -1; // 탈출 불가능
    }
}
