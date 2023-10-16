package lecture.inflearn_basic.sorting_searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 1. 정렬 사용
public class DuplicateCheck {
    public static String solution(int[] arr){
        String answer = "U";
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i]==arr[i+1]) answer = "D";
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(solution(arr));
    }
}

// 2. 해시맵 사용
//public class DuplicateCheck{
//    public static String solution(int[] arr){
//        String answer = "U";
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i : arr) {
//            if(!map.containsKey(i)) map.put(i, 1);
//            else answer = "D";
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
//        System.out.println(solution(arr));
//    }
//}