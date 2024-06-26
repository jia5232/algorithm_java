package lecture.school.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HanoiTower {
    public static void hanoiTower(int n, int start, int mid, int dest, BigInteger k){
        BigInteger valid = new BigInteger("2").pow(n-1);

        if(valid.compareTo(k) > 0){
            hanoiTower(n-1, start, dest, mid, k);
        }
        if(valid.compareTo(k) == 0){
            System.out.println(start+" "+dest);
        }
        if(valid.compareTo(k) < 0){
            hanoiTower(n-1, mid, start, dest, k.subtract(valid));
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            BigInteger k = new BigInteger(st.nextToken());
            hanoiTower(n, 1, 2, 3, k);
        }
    }
}





// 2. 두번째 풀이 -> k의 범위를 나누어 접근
//public class HanoiTower {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        for (int i = 0; i < num; i++) {
//            int n = sc.nextInt(); //원반 개수
//            BigInteger k = sc.nextBigInteger(); //k번째
//            hanoiTower(n, 1, 2, 3, k);
//        }
//    }
//
//    public static void hanoiTower(int n, int start, int mid, int dest, BigInteger k){
//        BigInteger t = new BigInteger("2");
//        BigInteger valid = t.pow(n-1); //절반으로 나눈다.
//
//        if(n==0) return;
//
//        if(k.compareTo(valid)<0){ //k가 2^n % 2보다 작으면
//            // N-1개를 A -> B로
//            hanoiTower(n-1, start, dest, mid, k);
//        }
//
//        if(k.compareTo(valid)==0){
//            // 1개를 A -> C로
//            System.out.println(start+" "+dest);
//        }
//
//        if(k.compareTo(valid)>0){
//            // N-1개를 B -> C로
//            hanoiTower(n-1, mid, start, dest, k.subtract(valid));
//        }
//    }
//}

// 1. 첫번쨰 풀이 -> 큰 수는 다루지 못함..
//public class HanoiTower {
//    public static BigInteger moveCount;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        for (int i = 0; i < num; i++) {
//            moveCount = BigInteger.valueOf(0);
//            int n = sc.nextInt();
//            BigInteger k = sc.nextBigInteger();
//            hanoiTower(n, 1, 2, 3, k);
//        }
//    }
//
//    // Q. K번째 순서쌍을 어떻게 출력하나
//    public static void hanoiTower(int n, int start, int mid, int dest, BigInteger k){
//        if(n==0) return;
//
//        // N-1개를 A -> B로
//        hanoiTower(n-1, start, dest, mid, k);
//
//        // 1개를 A -> C로
//        moveCount = moveCount.add(BigInteger.valueOf(1));
//        if(moveCount.equals(k)) System.out.println(start+" "+dest);
//
//        // N-1개를 B -> C로
//        hanoiTower(n-1, mid, start, dest, k);
//    }
//}