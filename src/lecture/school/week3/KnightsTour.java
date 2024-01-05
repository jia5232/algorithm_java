package lecture.school.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KnightsTour {
    static int[][] board;
    static int[][] path;

    static class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static Point[] direction = {
            new Point(-2, 1), new Point(-1, 2), new Point(1, 2), new Point(2, 1),
            new Point(2, -1), new Point(1, -2), new Point(-1, -2), new Point(-2, -1)
    };

    public static boolean knightTour(int[][] board, Point p, int counter){
        int m = board.length;
        int n = board[0].length;

        if(counter==m*n) return true;
        for (int i = 0; i < direction.length; i++) {
            Point newP = new Point(p.r+direction[i].r, p.c+direction[i].c);
            if(newP.r>=0 && newP.r<m && newP.c>=0 && newP.c<n && board[newP.r][newP.c]==0){
                board[newP.r][newP.c] = 1;
                path[newP.r][newP.c] = counter+1;
                if(knightTour(board, newP, counter+1)) return true;
                board[newP.r][newP.c] = 0;
            }
        }
        return false;
    }

    public static void printTour(){
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                System.out.print(path[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken())-1;
            board = new int[m][n];
            path = new int[m][n];
            board[s][t] = 1;
            path[s][t] = 1;
            if(knightTour(board, new Point(s, t), 1)){
                System.out.println(1);
                printTour();
            }
            else System.out.println(0);
        }
    }
}