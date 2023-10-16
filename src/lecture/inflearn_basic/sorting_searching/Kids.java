package lecture.inflearn_basic.sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 1. 내 풀이
//public class Kids {
//    public static void solution(int[] arr){
//        StringBuilder sb = new StringBuilder();
//        int index = 0;
//        for (int i = 0; i < arr.length-1; i++) {
//            if(arr[i]>arr[i+1]){
//                if(index==0) {
//                    sb.append(i+1).append(" "); //철수
//                    index++;
//                }
//                else sb.append(i+2).append("\n"); //철수 짝꿍
//            }
//        }
//        System.out.println(sb);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
//        solution(arr);
//    }
//}

// 2. 강의 풀이
public class Kids {
    public static ArrayList<Integer> solution(int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone(); //깊은 복사
        Arrays.sort(tmp);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=tmp[i]) answer.add(i+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (Integer i : solution(arr)) System.out.print(i+" ");
    }
}
