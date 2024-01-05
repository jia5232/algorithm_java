package lecture.school.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {
    public static int binarySearch(int[] arr, int index, int k){
        if(index==arr.length) return -1;

        if(arr[index]==k) return index;
        else return binarySearch(arr, index+1, k);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(arr, 0, k));
        }
    }
}