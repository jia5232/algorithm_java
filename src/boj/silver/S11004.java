package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11004 { //k번째 수 - 퀵정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        quickSort(arr, 0, n-1, k-1);
        System.out.println(arr[k-1]);
    }

    public static void quickSort(int[] arr, int start, int end, int k){
        if(start < end){
            int pivot = partition(arr, start, end);
            if(pivot==k) return;
            else if(k<pivot) quickSort(arr, start, pivot-1, k);
            else quickSort(arr, pivot+1, end, k);
        }
    }

    public static int partition(int[] arr, int start, int end){ //피벗의 위치를 반환
        if(start+1==end){ //데이터가 두개인 경우 바로 비교해서 정렬
            if(arr[start]>arr[end]) swap(arr, start, end);
            return end;
        }
        int mid = (start+end) / 2;
        swap(arr, mid, start); //중앙값을 1번째 요소로 사용
        int pivot = arr[start];
        int i = start+1, j = end;
        while (i<=j){
            while (pivot<arr[j] && j>0) j--; //피벗보다 작은수 나올때까지 j--
            while (pivot>arr[i] && i<arr.length-1) i++; //피벗보다 큰수 나올떄까지 i++
            //이제 arr[i]는 피벗보다 큰수, arr[j]는 피벗보다 작은수이다.
            if(i<=j){
                swap(arr, i++, j--);
            }
        }
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
