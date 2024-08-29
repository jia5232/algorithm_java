package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Island {
    static int n, answer;
    static int[][] board;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        answer = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                board[i][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==1){
                    Queue<Node> queue = new LinkedList<>();
                    queue.add(new Node(i, j));
                    board[i][j] = 0;
                    while (!queue.isEmpty()){
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            Node now = queue.poll();
                            for (int l = 0; l < 8; l++) {
                                int nextR = now.r + dr[l];
                                int nextC = now.c + dc[l];
                                if(nextR>=0 && nextR<n && nextC>=0 && nextC<n && board[nextR][nextC]==1){
                                    queue.add(new Node(nextR, nextC));
                                    board[nextR][nextC] = 0;
                                }
                            }
                        }
                    }
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}

class Node{
    int r, c;

    public Node(int r, int c){
        this.r = r;
        this.c = c;
    }
}