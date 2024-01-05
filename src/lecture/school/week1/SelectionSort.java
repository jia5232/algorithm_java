package lecture.school.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SelectionSort {
    static StringTokenizer st;
    public static void selectionSort(int[] arr){
        int comparison = 0;
        int swapNum = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int jMin = i;
            for (int j = i+1; j < arr.length; j++) {
                comparison++;
                if(arr[jMin] > arr[j]){
                    jMin = j;
                }
            }
            if(jMin != i){
                swap(arr, jMin, i);
                swapNum++;
            }
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
            selectionSort(arr.clone());
            System.out.println();
        }
    }
}