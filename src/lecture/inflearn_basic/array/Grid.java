package lecture.inflearn_basic.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][num];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < num; i++) {
            int r_tmp = 0; //행끼리 더한 것
            int c_tmp = 0; //열끼리 더한 것
            for (int j = 0; j < num; j++) {
                r_tmp += arr[i][j];
                c_tmp += arr[j][i];
            }
            arrayList.add(r_tmp);
            arrayList.add(c_tmp);
        }

        int right_tmp = 0; //오른쪽 대각선
        int left_tmp = 0; //왼쪽 대각선
        for (int i = 0; i < num; i++) {
            right_tmp += arr[i][i]; //[0][0], [1][1], [2][2], ...
            left_tmp += arr[i][num-i-1]; //[0][4], [1][3], [2][2], ...
        }
        arrayList.add(right_tmp);
        arrayList.add(left_tmp);

        System.out.println(Collections.max(arrayList));
    }
}
