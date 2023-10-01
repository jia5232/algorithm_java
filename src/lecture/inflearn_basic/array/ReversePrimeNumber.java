package lecture.inflearn_basic.array;

import java.util.ArrayList;
import java.util.Scanner;

// 1. 내 풀이
//public class ReversePrimeNumber {
//    public static boolean isPrime(int n){
//        if(n==1) return false;
//        for (int i = 2; i < (int)Math.sqrt(n); i++) {
//            if(n%i==0) return false;
//        }
//        return true;
//    }
//    public static void solution(int[] arr){
//        ArrayList<Integer> array = new ArrayList<>();
//        for (int n : arr) {
//            String tmpStr = String.valueOf(n);
//            String reverseStr = new StringBuilder(tmpStr).reverse().toString();
//            int reverseInt = Integer.parseInt(reverseStr);
//            if(isPrime(reverseInt)) array.add(reverseInt);
//        }
//        for (Integer integer : array) {
//            System.out.print(integer+" ");
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int[] arr = new int[num];
//        for (int i = 0; i < num; i++) {
//            arr[i] = sc.nextInt();
//        }
//        solution(arr);
//    }
//}

// 2. 강의 풀이
public class ReversePrimeNumber{
    public static boolean isPrime(int n){
        if(n==1) return false;
        for (int i = 2; i < n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    public static ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp>0){
                int t = tmp%10;
                res = res*10 + t;
                tmp = tmp/10;
            }
            if(isPrime(res)) result.add(res);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (Integer integer : solution(n, arr)) {
            System.out.print(integer + " ");
        }
    }
}