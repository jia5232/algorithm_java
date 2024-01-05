package lecture.school.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kadane {
    public static void solution(int[] arr){
        int start = -1, end = -1, thisSum = 0, maxSum = 0;
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if(arr[i]==0){
                i++;
                continue;
            }
            thisSum += arr[j];
            if(thisSum>maxSum){
                maxSum = thisSum;
                start = i;
                end = j;
            }
            if(thisSum<0){
                i = j+1;
                thisSum = 0;
            }
        }
        System.out.println(maxSum+" "+start+" "+end);
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
