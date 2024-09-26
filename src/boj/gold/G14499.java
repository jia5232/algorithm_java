package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G14499 {
    static int n, m, x, y;
    static int[][] board;
    static int[] dice = new int[7]; // 주사위 면을 저장
    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        // 입력 처리
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);
        y = Integer.parseInt(input[3]);
        int k = Integer.parseInt(input[4]);

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        String[] moves = br.readLine().split(" ");

        for (int i = 0; i < k; i++) {
            int direction = Integer.parseInt(moves[i]);
            move(direction);
        }
    }

    static void move(int direction) {
        int nx = x + dr[direction]; // 이동할 새로운 위치
        int ny = y + dc[direction];

        // 경계 밖으로 나가면 무시
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
            return;
        }

        // 주사위를 이동시킴
        rollDice(direction);

        // 주사위의 위치를 갱신
        x = nx;
        y = ny;

        // 주사위와 보드 상호작용
        if (board[x][y] == 0) {
            board[x][y] = dice[6]; // 주사위 바닥면 값 복사
        } else {
            dice[6] = board[x][y]; // 보드 값 복사
            board[x][y] = 0; // 보드 값 0으로
        }

        // 주사위 윗면 출력
        System.out.println(dice[1]);
    }

    static void rollDice(int direction) {
        int[] temp = dice.clone(); // 주사위 배열을 임시 저장

        // 방향에 따른 주사위 면 변경
        switch (direction) {
            case 1: // 동쪽
                dice[1] = temp[4];
                dice[3] = temp[1];
                dice[4] = temp[6];
                dice[6] = temp[3];
                break;
            case 2: // 서쪽
                dice[1] = temp[3];
                dice[3] = temp[6];
                dice[4] = temp[1];
                dice[6] = temp[4];
                break;
            case 3: // 북쪽
                dice[1] = temp[5];
                dice[2] = temp[1];
                dice[5] = temp[6];
                dice[6] = temp[2];
                break;
            case 4: // 남쪽
                dice[1] = temp[2];
                dice[2] = temp[6];
                dice[5] = temp[1];
                dice[6] = temp[5];
                break;
        }
    }
}
