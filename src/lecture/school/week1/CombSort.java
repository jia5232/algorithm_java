package lecture.school.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int iter =  scanner.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < iter; j++) {
                arr.add(scanner.nextInt());
            }
            combSort((ArrayList<Integer>) arr.clone());
        }
    }

    public static void swap(List<Integer> arrayList, int index1, int index2){
        int tmp = arrayList.get(index1);
        arrayList.set(index1, arrayList.get(index2));
        arrayList.set(index2, tmp);
    }

    public static void combSort(List<Integer> arrayList){
        int comparison = 0;
        int swapNum = 0;
        double gap = arrayList.size();
        double shrink = 1.3;
        boolean sorted = false;

        while (sorted==false){
            gap = Math.floor(gap/shrink);
            if(gap<=1){
                gap = 1;
                sorted = true;
            }
            int i = 0;
            while (i+gap < arrayList.size()){
                comparison++;
                if(arrayList.get(i) > arrayList.get(i+(int)gap)){
                    swap(arrayList, i, i+(int)gap);
                    swapNum++;
                    sorted = false;
                }
                i+=1;
            }
        }
        System.out.println(comparison+ " " +swapNum);
    }
}
