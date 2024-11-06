package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G3055 {
    static int n, m;
    static char[][] board;
    static int[][] spreading, visited;
    static Queue<int[]> spots = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        board = new char[n][m];
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = inputArr[j].charAt(0);

                if(board[i][j]=='S'){
                    start[0] = i;
                    start[1] = j;
                }
                if(board[i][j]=='D'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        int time = 0;
        boolean isFound = false;
        visited = new int[n][m];
        spots.add(start);
        visited[start[0]][start[1]] = 1;
        while (!spots.isEmpty()){
            if(isFound) break;

            time++;

            spread();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(spreading[i][j]==1){
                        board[i][j] = '*';
                    }
                }
            }

            int size = spots.size();
            for (int i = 0; i < size; i++) {
                if(isFound) break;

                int[] now = spots.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && (board[nr][nc]=='.' || board[nr][nc]=='D') && visited[nr][nc]==0){
                        visited[nr][nc] = 1;

                        if(end[0]==nr && end[1]==nc){
                            isFound = true;
                            break;
                        } else{
                            spots.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        if(isFound) System.out.println(time);
        else System.out.println("KAKTUS");
    }

    public static int spread(){
        int answer = 0;
        spreading = new int[n][m];
        int[][] ch = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]=='*'){
                    queue.add(new int[]{i, j});
                    ch[i][j] = 1;
                }
            }
        }
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]=='.' && ch[nr][nc]==0){
                    ch[nr][nc] = 1;
                    answer++;
                    spreading[nr][nc] = 1;
                }
            }
        }
        return answer;
    }
}
