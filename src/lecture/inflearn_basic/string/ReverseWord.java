package lecture.inflearn_basic.string;

import java.util.Scanner;

// 1.
//public class ReverseWord {
//    public static void solution(String[] arr){
//        for(String s : arr){
//            for(int i=0; i<s.length(); i++){
//                System.out.print(s.charAt(s.length()-i-1));
//            }
//            System.out.println();
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] arr = new String[n];
//        for(int i=0; i<n; i++){
//            arr[i] = sc.next();
//        }
//        solution(arr);
//    }
//}

// 2. StringBuilder의 reverse()사용
//public class ReverseWord {
//    public static void solution(String[] arr){
//        for(String s : arr){
//            String tmp = new StringBuilder(s).reverse().toString();
//            System.out.println(tmp);
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] arr = new String[n];
//        for(int i=0; i<n; i++){
//            arr[i] = sc.next();
//        }
//        solution(arr);
//    }
//}

// 3. 직접 뒤집기
public class ReverseWord {
    public static void solution(String[] arr){
        for(String s : arr){
            char[] c = s.toCharArray();
            int lt=0, rt=s.length()-1;
            while(lt<rt){
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
            String result = String.valueOf(c);
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.next();
        }
        solution(arr);
    }
}