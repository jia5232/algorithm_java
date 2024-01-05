package lecture.school.middle_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinomialCoefficient {
    static int[][] arr;

    public static int solution(int n, int k){
        if(k==0 || k==n) return 1;

        if(arr[n][k]!=0) return arr[n][k];
        else return arr[n][k] = (solution(n-1, k-1)+solution(n-1, k))%1000;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            arr = new int[101][101];
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            System.out.println(solution(n, k));
        }
    }
}