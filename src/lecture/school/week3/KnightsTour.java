package lecture.school.week3;

import java.util.Scanner;

public class KnightsTour {
    static int[][] board;
    static int[][] path;
    static Point[] direction = {new Point(1, -2), new Point(2, -1), new Point(2, 1), new Point(1, 2),
            new Point(-1, 2), new Point(-2, 1), new Point(-2, -1), new Point(-1, -2)};

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean knightTour(int m, int n, Point pos, int counter) {
        if (counter == m * n)
            return true;

        for (int i = 0; i < direction.length; i++) {
            Point next = new Point(pos.x + direction[i].x, pos.y + direction[i].y);
            if (next.x >= 0 && next.x < n && next.y >= 0 && next.y < m && board[next.y][next.x] != 1) {
                board[next.y][next.x] = 1;
                path[next.y][next.x] = counter + 1;
                if (knightTour(m, n, next, counter + 1))
                    return true;
                board[next.y][next.x] = 0;
            }
        }
        return false;
    }

    static void printTour() {
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for(int testCase = 0; testCase < num; testCase++){
            int m,n,s,t;
            m = scanner.nextInt();
            n = scanner.nextInt();
            s = scanner.nextInt() - 1;
            t = scanner.nextInt() - 1;
            board = new int[m][n]; //밟았는지 안밟았는지
            path = new int[m][n]; //몇번째로 밟았는지

            board[s][t] = 1;
            path[s][t] = 1;

            if(knightTour(m, n, new Point(t,s), 1)){ //s가 행, t가 열 -> t가 x, s가 y
                System.out.println(1);
                printTour();
            } else {
                System.out.println(0);
            }
        }
    }
}
