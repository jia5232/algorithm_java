package lecture.school.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int iter = scanner.nextInt();
            for (int j = 0; j < iter; j++) {
                arr.add(scanner.nextInt());
            }
            insertionSort((ArrayList<Integer>) arr.clone());
        }
    }

    public static void swap(List<Integer> arrayList, int index1, int index2){
        int tmp = arrayList.get(index1);
        arrayList.set(index1, arrayList.get(index2));
        arrayList.set(index2, tmp);
    }

    public static void insertionSort(List<Integer> arrayList){
        int comparison = 0;
        int swapNum = 0;
        int size = arrayList.size();
        for (int i = 1; i < size; i++) {
            int tmp = i; //2
            for (int j = i; j > 0 && arrayList.get(j-1) > arrayList.get(j); j--) {
                comparison+=1;//true+true -> 1
                swap(arrayList, j-1, j);
                swapNum++;
                tmp = j - 1; //0
            }
            if(tmp > 0) comparison+=1;//true+false -> 1
        }
        System.out.println(comparison+" "+swapNum);
    }
}
