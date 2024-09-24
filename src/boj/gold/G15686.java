package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G15686 {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] board;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> houses = new ArrayList<>();
    static int[] combi;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
                if(board[i][j]==2){
                    chickens.add(new int[]{i, j});
                }
                if(board[i][j]==1){
                    houses.add(new int[]{i, j});
                }
            }
        }
        combi = new int[m];
        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int L, int s){
        if(L==m){
            int cityLength = 0;
            for(int[] house : houses){
                int houseLength = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++) {
                    int[] chicken = chickens.get(combi[i]);
                    houseLength = Math.min(houseLength, Math.abs(chicken[0]-house[0])+Math.abs(chicken[1]-house[1]));
                }
                cityLength += houseLength;
            }
            answer = Math.min(answer, cityLength);
        } else {
            for (int i = s; i < chickens.size(); i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
}
