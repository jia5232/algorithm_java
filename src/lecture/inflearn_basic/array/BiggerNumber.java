package lecture.inflearn_basic.array;

import java.util.ArrayList;
import java.util.Scanner;

public class BiggerNumber {
    public static void solution(int[] array){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if(i==0) arrayList.add(array[i]);
            else{
                if(array[i-1]<array[i]) arrayList.add(array[i]);
            }
        }
        for (Integer i : arrayList) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr);
    }
}
