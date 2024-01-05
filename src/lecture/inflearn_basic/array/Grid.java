package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Grid {
    public static int solution(int[][] arr){
        int answer = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int r_tmp = 0; //한 행의 합
            int c_tmp = 0; //한 열의 합
            for (int j = 0; j < arr.length; j++) {
                r_tmp += arr[i][j];
                c_tmp += arr[j][i];
            }
            arrayList.add(r_tmp);
            arrayList.add(c_tmp);
        }

        int right_tmp = 0; //오른쪽으로 가는 대각선의 합
        int left_tmp = 0; //왼쪽으로 가는 대각선의 합
        for (int i = 0; i < arr.length; i++) {
            right_tmp += arr[i][i]; //[0][0] [1][1] [2][2]...
            left_tmp += arr[i][arr.length-i-1]; //[0][4] [1][3] [2][2]...
        }
        arrayList.add(right_tmp);
        arrayList.add(left_tmp);

        return Collections.max(arrayList);
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
        System.out.println(solution(arr));
    }
}