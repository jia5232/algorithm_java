package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G2023 {
    static int n;
    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        number = new int[n];
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    public static void DFS(int num, int jarisu){
        if(jarisu==n){
            if(isPrime(num)) System.out.println(num);
        } else{
            for (int i = 1; i <= 9; i+=2) {
                int tmp = num*10 + i;
                if(isPrime(tmp)){
                    DFS(tmp, jarisu+1);
                }
            }
        }
    }

    public static boolean isPrime(int n){
        for (int i = 2; i < n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}