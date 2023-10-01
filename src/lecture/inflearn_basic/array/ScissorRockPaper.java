package lecture.inflearn_basic.array;

import java.util.Scanner;

public class ScissorRockPaper {
    public static void solution(int n, int[] aArray, int[]bArray){
        String answer = "";
        for (int i = 0; i < n; i++) {
            if(aArray[i]==bArray[i]) System.out.println("D");
            else if (aArray[i]==1 && bArray[i]==3) System.out.println("A");
            else if(aArray[i]==2 && bArray[i]==1) System.out.println("A");
            else if(aArray[i]==3 && bArray[i]==2) System.out.println("A");
            else System.out.println("B");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array_a = new int[num];
        int[] array_b = new int[num];
        for (int i = 0; i < num; i++) {
            array_a[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            array_b[i] = sc.nextInt();
        }
        solution(num, array_a, array_b);
    }
}
