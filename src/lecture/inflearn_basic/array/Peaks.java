package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Peaks {
    static int[][] arr;
    static int n;
    public static boolean isPeak(int r, int c){
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            int nextR = r + dr[k];
            int nextC = c + dc[k];
            if(!(nextR>=0 && nextR<n && nextC>=0 && nextC<n)) continue;
            if(arr[nextR][nextC]>=arr[r][c]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isPeak(i, j)) answer++;
            }
        }
        System.out.println(answer);
    }
}
