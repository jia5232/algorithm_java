package lecture.school.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSortIterative {
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

    public static void mergeSort(int[] a, int n){
        int size = 1;
        while (size < n){
            for (int i = 0; i < n; i += 2*size) {
                int low = i;
                int middle = low + size - 1;
                int high = Math.min(i + size*2 - 1, n-1);

                if(middle >= n-1) break;
                merge(a, low, middle, high);
            }
            size *= 2;
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
            mergeSort(arr, num);
            System.out.println(comparison);
            comparison = 0;
        }
    }
}
