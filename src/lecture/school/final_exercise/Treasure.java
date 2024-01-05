package lecture.school.final_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Treasure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        int num = Integer.parseInt(br.readLine());
        int[] arrA = new int[num];
        Integer[] arrB = new Integer[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) arrA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) arrB[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());
        for (int i = 0; i < num; i++) {
            answer += arrA[i]*arrB[i];
        }
        System.out.println(answer);
    }
}
