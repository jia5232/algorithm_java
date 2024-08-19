package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grid {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmpR = 0, tmpC = 0;
            for (int j = 0; j < n; j++) {
                tmpC += arr[j][i];
                tmpR += arr[i][j];
            }
            answer = Math.max(answer, tmpC);
            answer = Math.max(answer, tmpR);
        }
        int right = 0, left = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j){
                    right += arr[i][j];
                    left += arr[i][n-j-1];
                }
            }
        }
        answer = Math.max(answer, right);
        answer = Math.max(answer, left);
        System.out.println(answer);
    }
}