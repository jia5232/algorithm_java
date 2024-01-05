package lecture.school.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombSort {
    static StringTokenizer st;
    public static void combSort(int[] arr){
        int comparison = 0;
        int swapNum = 0;

        double gap = arr.length;
        double shrink = 1.3;
        boolean sorted = false;

        while (sorted==false){
            gap = Math.floor(gap/shrink);
            if(gap<=1){
                gap = 1;
                sorted = true;
            }
            int i = 0;
            while (i+gap < arr.length){
                comparison++;
                if(arr[i] > arr[i+(int)gap]){
                    swap(arr, i, i+(int)gap);
                    sorted = false;
                    swapNum++;
                }
                i++;
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
            combSort(arr.clone());
            System.out.println();
        }
    }
}