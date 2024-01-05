package boj.workbook.devide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColoredPaper {
    static int blue = 0, white = 0;
    public static void getPartition(int[][] arr, int r, int c, int n){
        if(isSameColor(arr, r, c, n)){
            if (arr[r][c]==1) blue++;
            else white++;
            return;
        }

        getPartition(arr, r, c, n/2);
        getPartition(arr, r, c + n/2, n/2);
        getPartition(arr, r + n/2, c, n/2);
        getPartition(arr, r + n/2, c + n/2, n/2);
    }

    public static boolean isSameColor(int[][] arr, int r, int c, int n){
        int tmp = arr[r][c];
        for (int i = r; i < r+n; i++) {
            for (int j = c; j < c+n; j++) {
                if(tmp!=arr[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        getPartition(arr, 0, 0, num);
        System.out.println(white);
        System.out.println(blue);
    }
}
