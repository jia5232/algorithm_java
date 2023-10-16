package lecture.school.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxValue {
    public static void recursive(int max, int[] arr, int index){
        if(index==arr.length){
            System.out.println(max);
            return;
        }
        if(max<arr[index]) max = arr[index];
        recursive(max, arr, ++index);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        for (int i = 0; i < iter; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            for (int j = 0; j < num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            recursive(0, arr, 0);
        }
    }
}
