package lecture.school.middle_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SecondMax {
    public static int findMaxIndex(int[] arr, int lt, int rt){
        if(lt==rt) return lt;
        int mid = (lt+rt) / 2;
        int leftMaxIndex = findMaxIndex(arr, lt, mid);
        int rightMaxIndex = findMaxIndex(arr, mid+1, rt);
        return arr[leftMaxIndex]>arr[rightMaxIndex] ? leftMaxIndex : rightMaxIndex;
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
            int maxIndex = findMaxIndex(arr, 0, n - 1);
            arr[maxIndex] = Integer.MIN_VALUE;
            int secondMaxIndex = findMaxIndex(arr, 0, n-1);
            System.out.println(arr[secondMaxIndex]);
        }
    }
}