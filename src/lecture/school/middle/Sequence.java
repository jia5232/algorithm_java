package lecture.school.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sequence {
    public static void solution(int[] arr){
        int before = arr[0];
        int max = 1;

        int tmp = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==before){
                tmp++;
            }
            if(arr[i]>before){
                before = arr[i];
                tmp++;
            }
            if(arr[i]<before){
                max = Math.max(max, tmp);
                before = arr[i];
                tmp = 1;
            }
            max = Math.max(max, tmp);
        }
        max = Math.max(max, tmp);
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
            solution(arr);
        }
    }
}