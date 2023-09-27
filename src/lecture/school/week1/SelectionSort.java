package lecture.school.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int iter = scanner.nextInt();
            for (int j = 0; j < iter; j++) {
                arr.add(scanner.nextInt());
            }
            selectionSort((ArrayList<Integer>) arr.clone());
        }
    }

    public static void swap(List<Integer> arrayList, int index1, int index2){
        int tmp = arrayList.get(index1);
        arrayList.set(index1, arrayList.get(index2));
        arrayList.set(index2, tmp);
    }

    public static void selectionSort(List<Integer> arrayList){
        int comparison = 0;
        int swapNum = 0;
        int size = arrayList.size();
        for (int i = 0; i < size-1; i++) {
            int jMin = i;

            for (int j = i+1; j < size; j++) {
                comparison++;
                if(arrayList.get(j) < arrayList.get(jMin)){
                    jMin = j;
                }
            }

            if(jMin != i){
                swap(arrayList, jMin, i);
                swapNum++;
            }
        }
        System.out.println(comparison + " " + swapNum);
    }
}
