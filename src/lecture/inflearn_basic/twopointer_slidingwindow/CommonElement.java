package lecture.inflearn_basic.twopointer_slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 1. 내 코드 -> 타임아웃
//public class CommonElement {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int numA = sc.nextInt();
//        int[] arrA = new int[numA];
//        for (int i = 0; i < numA; i++) {
//            arrA[i] = sc.nextInt();
//        }
//        int numB = sc.nextInt();
//        int[] arrB = new int[numB];
//        for (int i = 0; i < numB; i++) {
//            arrB[i] = sc.nextInt();
//        }
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 0; i < numA; i++) {
//            for (int j = 0; j < numB; j++) {
//                if (arrA[i]==arrB[j]) arrayList.add(arrA[i]);
//            }
//        }
//        Collections.sort(arrayList);
//
//        for (Integer integer : arrayList) {
//            System.out.print(integer+" ");
//        }
//    }
//}

// 2. 강의 코드
public class CommonElement{
    public static ArrayList<Integer> solution(int numA, int numB, int[] arrA, int[] arrB){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int p1=0, p2=0;
        while(p1<numA && p2<numB){
            if(arrA[p1]==arrB[p2]){
                answer.add(arrA[p1++]);
                p2++;
            }
            else if (arrA[p1]<arrB[p2]) p1++;
            else p2++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numA = sc.nextInt();
        int[] arrA = new int[numA];
        for (int i = 0; i < numA; i++) {
            arrA[i] = sc.nextInt();
        }
        int numB = sc.nextInt();
        int[] arrB = new int[numB];
        for (int i = 0; i < numB; i++) {
            arrB[i] = sc.nextInt();
        }
        for (Integer x : solution(numA, numB, arrA, arrB)) {
            System.out.print(x+" ");
        }
    }
}