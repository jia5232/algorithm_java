package lecture.inflearn_basic.twopointer_slidingwindow;

import java.util.ArrayList;
import java.util.Scanner;

public class CombineArray {
    public static ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1<n && p2<m){
            if(a[p1]<b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while (p1<n) answer.add(a[p1++]);
        while (p2<m) answer.add(b[p2++]);
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
        ArrayList<Integer> solution = solution(numA, numB, arrA, arrB);
        for (Integer integer : solution) {
            System.out.print(integer+" ");
        }
    }
}
