package lecture.school.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShellSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int iter = scanner.nextInt();
            for (int j = 0; j < iter; j++) {
                arr.add(scanner.nextInt());
            }
            shellSort((ArrayList<Integer>) arr.clone());
        }
    }

    public static void shellSort(List<Integer> arrayList){
        int comparison = 0;
        int swapNum = 0;
        int size = arrayList.size();
        int shrink = 2;
        int gap = size/shrink;

        while (gap>0){
            for (int i = gap; i < size; i++) {
                int tmp = arrayList.get(i);
                int jTmp = i;
                for (int j = i; j >= gap && (arrayList.get(j-gap) > tmp); j-=gap) {
                    comparison++;
                    jTmp = j-gap;
                    arrayList.set(j, arrayList.get(j-gap));
                    swapNum++;
                }
                if(jTmp>=gap) comparison++;
                arrayList.set(jTmp, tmp);
            }
            gap /= shrink;
        }
        System.out.println(comparison+" "+swapNum);
    }
}
