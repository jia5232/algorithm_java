package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReversePrimeNumber {
    public static boolean isPrime(int n){
        if(n==1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] inputArr = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            int reverseNum = Integer.parseInt(new StringBuilder(inputArr[i]).reverse().toString());
            arrayList.add(reverseNum);
        }
        for(int i : arrayList){
            if(isPrime(i)) System.out.print(i+" ");
        }
    }
}