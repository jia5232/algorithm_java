package lecture.school.week1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BubbleSort {
    public static void swap(int[] arr, int index1, int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    public static void bubbleSort(int[] arr){
        int comparison = 0;
        int swapNum = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= arr.length-i; j++) {
                comparison++;
                if(arr[j-1]>arr[j]){
                    swap(arr, j-1, j);
                    swapNum++;
                }
            }
        }

        System.out.print(comparison+" "+swapNum+" ");
    }

    public static void bubbleSortImproved1(int[] arr){
        int comparison = 0;
        int swapNum = 0;

        for (int i = 1; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 1; j <= arr.length-i; j++) {
                comparison++;
                if(arr[j-1]>arr[j]){
                    swap(arr, j-1, j);
                    swapNum++;
                    swapped = true;
                }
            }
            if(swapped==false) break;
        }
        System.out.print(comparison+" "+swapNum+" ");
    }

    public static void bubbleSortImproved2(int[] arr){
        int comparison = 0;
        int swapNum = 0;

        int lastSwappedPos = arr.length;
        while (lastSwappedPos>0){
            int swappedPos = 0;
            for (int i = 1; i < lastSwappedPos; i++) {
                comparison++;
                if(arr[i-1]>arr[i]){
                    swap(arr, i-1, i);
                    swapNum++;
                    swappedPos = i;
                }
            }
            lastSwappedPos = swappedPos;
        }
        System.out.print(comparison+" "+swapNum+" ");
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
            bubbleSort(arr.clone());
            bubbleSortImproved1(arr.clone());
            bubbleSortImproved2(arr.clone());
            System.out.println();
        }
    }
}