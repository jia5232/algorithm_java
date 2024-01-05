package lecture.school.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static Long factorial(int n){
        if(n==0) return 1L;
        else {
            Long tmp = n*factorial(n-1);
            while (tmp%10==0){
                tmp/=10;
            }
            return tmp % 100000000;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(factorial(n) % 1000);
        }
    }
}