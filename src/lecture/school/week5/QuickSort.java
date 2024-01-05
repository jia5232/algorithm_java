package lecture.school.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
    static int comparison_h = 0, swapNum_h = 0;
    static int comparison_l = 0, swapNum_l = 0;

    public static void quickSortHoare(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = hoarePartition(arr, low, high);
            quickSortHoare(arr, low, pivotIndex);
            quickSortHoare(arr, pivotIndex + 1, high);
        }
    }

    public static void quickSortLomuto(int[] arr, int low, int high) {
        if(low < high){
            int pivotIndex = lomutoPartition(arr, low, high);
            quickSortLomuto(arr, low, pivotIndex - 1);
            quickSortLomuto(arr, pivotIndex + 1, high);
        }
    }

    public static int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                comparison_h++;
                i++;
            } while (arr[i] < pivot);
            do {
                comparison_h++;
                j--;
            } while (arr[j] > pivot);
            if (i >= j) return j;
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            swapNum_h++;
        }
    }

    public static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;

        for (int j = low+1; j <= high; j++) {
            comparison_l++;
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                swapNum_l++;
            }
        }

        int tmp = arr[i];
        arr[i] = arr[low];
        arr[low] = tmp;
        swapNum_l++;

        return i;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
            int[] hoareArr = arr.clone();
            int[] lomutoArr = arr.clone();
            quickSortHoare(hoareArr, 0, n - 1);
            quickSortLomuto(lomutoArr, 0, n - 1);
            System.out.println(swapNum_h+" "+swapNum_l+" "+comparison_h+" "+comparison_l);
            swapNum_h = 0;
            swapNum_l = 0;
            comparison_h = 0;
            comparison_l = 0;
        }
    }
}
