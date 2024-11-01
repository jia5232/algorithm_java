package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G14502 {
    static int n, m, len, max = 0;
    static int[][] board;
    static int[] combi, ch;
    static ArrayList<int[]> candidates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(inputArr[j]);
                board[i][j] = tmp;
                if(tmp==0) candidates.add(new int[]{i, j});
            }
        }
        len = candidates.size();
        combi = new int[3];
        ch = new int[len];
        DFS(0, 0);
        System.out.println(max);
    }

    public static void DFS(int L, int s){
        if(L==3){
            int[][] copiedBoard = new int[n][m];
            for (int i = 0; i < n; i++) {
                copiedBoard[i] = board[i].clone();
            }
            for(int i : combi){
                int[] now = candidates.get(i);
                copiedBoard[now[0]][now[1]] = 1;
            }
            int safeArea = BFS(copiedBoard);
            max = Math.max(max, safeArea);
        } else {
            for(int i=s; i<len; i++){
                if(ch[i]==0){
                    ch[i] = 1;
                    combi[L] = i;
                    DFS(L+1, i+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static int BFS(int[][] copiedBoard){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int[][] ch = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(copiedBoard[i][j]==2){
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
                if(nr>=0 && nr<n && nc>=0 && nc<m && ch[nr][nc]==0 && copiedBoard[nr][nc]==0){
                    ch[nr][nc] = 1;
                    copiedBoard[nr][nc] = 2;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(copiedBoard[i][j]==0) answer++;
            }
        }
        return answer;
    }
}
