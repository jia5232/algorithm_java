package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReversePrimeNumber {
    public static boolean isPrime(int n){
        if(n==1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void solution(int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int reverseNum = 0;
            while (tmp>0){
                reverseNum = reverseNum*10 + tmp%10;
                tmp /= 10;
            }
            if(isPrime(reverseNum)) result.add(reverseNum);
        }
        for (Integer i : result) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());
        solution(arr);
    }
}