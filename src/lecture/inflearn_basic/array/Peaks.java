package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Peaks {
    public static int solution(int num, int[][] arr){
        int answer = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                int tmpPeak = arr[i][j];
                if(tmpPeak>arr[i-1][j] && tmpPeak>arr[i+1][j] && tmpPeak>arr[i][j-1] && tmpPeak>arr[i][j+1]){
                    answer++;
                }
            }
        }
        return answer++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num+2][num+2];
        for (int i = 1; i <= num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(num, arr));
    }
}
