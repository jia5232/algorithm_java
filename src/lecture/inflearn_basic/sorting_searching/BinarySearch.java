package lecture.inflearn_basic.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
    public static int solution(int[] arr, int m){
        Arrays.sort(arr);
        int answer = 0, lt = 0, rt = arr.length-1;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if(arr[mid]==m) {
                answer = mid+1;
                break;
            }
            if(arr[mid]<m) lt = mid+1;
            else rt = mid-1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(arr, m));
    }
}