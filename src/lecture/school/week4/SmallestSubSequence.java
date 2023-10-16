package lecture.school.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SmallestSubSequence {
    public static void count(int[] arr){
        int length = 1;
        int startValue = arr[0];
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>=startValue){
                length++;
            }
            else{
                startValue = arr[i];
                if(max<length) max = length;
                length = 1;
            }
        }
        if(max<length) max = length;
        System.out.println(max);
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
            count(arr);
        }
    }
}