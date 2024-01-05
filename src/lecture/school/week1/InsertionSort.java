package lecture.school.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertionSort {
    static StringTokenizer st;
    public static void insertionSort(int[] arr){
        int comparison = 0;
        int swapNum = 0;

        for (int i = 1; i < arr.length; i++) {
            int tmp = i; //2
            for (int j = i; j>0 && arr[j-1]>arr[j]; j--) {
                comparison++; //true+true -> 1
                swap(arr, j-1, j);
                swapNum++;
                tmp = j - 1; //0
            }
            if(tmp>0) comparison++; //true+false -> 1
        }
        System.out.print(comparison+" "+swapNum+" ");
    }
    public static void swap(int[] arr, int index1, int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            for (int j = 0; j < num; j++) arr[j] = Integer.parseInt(st.nextToken());
            insertionSort(arr.clone());
            System.out.println();
        }
    }
}