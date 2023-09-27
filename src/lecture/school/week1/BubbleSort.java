package lecture.school.week1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int iter = scanner.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < iter; j++) {
                arr.add(scanner.nextInt());
            }

            bubbleSort((ArrayList<Integer>) arr.clone());
            bubbleSortImproved1((ArrayList<Integer>) arr.clone());
            bubbleSortImproved2((ArrayList<Integer>) arr.clone());
            System.out.println();
        }
    }

    public static void swap(List<Integer> arrayList, int index1, int index2){
        int tmp = (int) arrayList.get(index1);
        arrayList.set(index1, arrayList.get(index2));
        arrayList.set(index2, tmp);
    }

    public static void bubbleSort(List<Integer> arrayList){
        int comparison = 0;
        int swapNum = 0;
        for (int i = 1; i < arrayList.size(); i++) {
            for (int j = 1; j <= arrayList.size()-i; j++) {
                comparison++;
                if((int)arrayList.get(j-1) > (int)arrayList.get(j)){
                    swap(arrayList, j-1, j);
                    swapNum++;
                }
            }
        }
        System.out.print(comparison+" "+swapNum+" ");
    }

    public static void bubbleSortImproved1(List<Integer> arrayList){
        int comparison = 0;
        int swapNum = 0;
        for (int i = 1; i < arrayList.size(); i++) {
            boolean swapped = false;
            for (int j = 1; j <= arrayList.size()-i; j++) {
                comparison++;
                if((int)arrayList.get(j-1) > (int)arrayList.get(j)){
                    swap(arrayList, j-1, j);
                    swapNum++;
                    swapped = true;
                }
            }
            if(swapped==false) break;
        }
        System.out.print(comparison+" "+swapNum+" ");
    }

    public static void bubbleSortImproved2(List<Integer> arrayList){
        int comparison = 0;
        int swapNum = 0;
        int lastSwappedPos = arrayList.size();
        while (lastSwappedPos > 0){
            int swappedPos = 0;
            for (int i = 1; i < lastSwappedPos; i++) {
                comparison++;
                if((int)arrayList.get(i-1) > (int)arrayList.get(i)){
                    swap(arrayList, i-1, i);
                    swapNum++;
                    swappedPos = i;
                }
            }
            lastSwappedPos = swappedPos;
        }
        System.out.print(comparison+" "+swapNum);
    }
}
