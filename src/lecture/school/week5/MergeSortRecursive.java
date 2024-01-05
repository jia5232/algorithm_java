package lecture.school.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSortRecursive {
    static int comparison = 0;
    public static void merge(int[] a, int low, int mid, int high){
        int i, j, k;
        int[] tmp = a.clone();
        i = k = low;
        j = mid+1;
        while (i<=mid && j<=high){
            comparison++;
            if(tmp[i] <= tmp[j]) a[k++] = tmp[i++];
            else a[k++] = tmp[j++];
        }
        //한쪽 배열이라도 다 끝나면 나머지 배열은 쭉 넣어주면 된다.
        while (i<=mid) a[k++] = tmp[i++];
        while (j<=high) a[k++] = tmp[j++];
    }

    public static void mergeSort(int[] a, int m, int n){
        if(m < n){
            //일단 분할하고
            int middle = (m+n) / 2;
            mergeSort(a, m, middle);
            mergeSort(a, middle+1, n);
            //나중에 합쳐준다!
            merge(a, m, middle, n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            for (int j = 0; j < num; j++) arr[j] = Integer.parseInt(st.nextToken());
            mergeSort(arr, 0, arr.length-1);
            System.out.println(comparison);
            comparison = 0;
        }
    }
}
