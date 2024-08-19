package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mentoring {
    static int[][] arr;
    static int n, m;
    public static boolean isAvailable(int a, int b){
        for (int i = 0; i < m; i++) { //전체 시험 횟수 m번에 대해서
            int idxA = 0, idxB = 0;
            for (int j = 0; j < n; j++) {
                if(arr[i][j]==a) idxA = j;
                if(arr[i][j]==b) idxB = j;
            }
            if(idxA>=idxB) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]); //반 학생수
        m = Integer.parseInt(inputArr[1]); //테스트 수
        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) { //i번 학생 기준으로
            for (int j = 0; j < n; j++) { //j번 학생이 멘티가 될 수 있는지
                if(i==j) continue;
                if(isAvailable(i+1, j+1)) answer++;
            }
        }
        System.out.println(answer);
    }
}