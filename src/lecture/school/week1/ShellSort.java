package lecture.school.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

//public class ShellSort {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            ArrayList<Integer> arr = new ArrayList<>();
//            int iter = scanner.nextInt();
//            for (int j = 0; j < iter; j++) {
//                arr.add(scanner.nextInt());
//            }
//            shellSort((ArrayList<Integer>) arr.clone());
//        }
//    }
//
//    public static void shellSort(List<Integer> arrayList){
//        int comparison = 0;
//        int swapNum = 0;
//        int size = arrayList.size();
//        int shrink = 2;
//        int gap = size/shrink;
//
//        while (gap>0){
//            for (int i = gap; i < size; i++) {
//                int tmp = arrayList.get(i);
//                int jTmp = i;
//                for (int j = i; j >= gap && (arrayList.get(j-gap) > tmp); j-=gap) {
//                    comparison++;
//                    jTmp = j-gap;
//                    arrayList.set(j, arrayList.get(j-gap));
//                    swapNum++;
//                }
//                if(jTmp>=gap) comparison++;
//                arrayList.set(jTmp, tmp);
//            }
//            gap /= shrink;
//        }
//        System.out.println(comparison+" "+swapNum);
//    }
//}

public class ShellSort { //이해 안감,,,...
    static StringTokenizer st;

    public static void shellSort(int[] arr){
        int shrink = 2;
        int gap = 2/shrink;
        while (gap>0){
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int jTmp = i;
                for (int j = i; j>=gap && arr[j-gap]>tmp; j-=gap) {
                    jTmp = j-gap;
                    arr[j] = arr[j-gap];
                }
                arr[jTmp] = tmp;
            }
            gap /= shrink;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            for (int j = 0; j < num; j++) arr[j] = Integer.parseInt(st.nextToken());
            shellSort(arr.clone());
            System.out.println();
        }
    }
}