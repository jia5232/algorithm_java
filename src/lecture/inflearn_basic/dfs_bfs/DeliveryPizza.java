package lecture.inflearn_basic.dfs_bfs;

import java.util.*;

public class DeliveryPizza {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    static int n;
    static int m;
    static int[][] board;
    static int answer = Integer.MAX_VALUE; //최소값을 구한다.
    static List<int[]> pizza = new ArrayList<>();

    public static void DFS(int x, int y, int[][] board){

    }

    public static void solution(int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                if(board[i][j]==2){
                    pizza.add(new int[] {i, j});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        solution(board);
        System.out.println(answer);
    }
}
