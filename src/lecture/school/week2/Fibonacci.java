package lecture.school.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(fibonacci(n));
        }
    }

    public static int fibonacci(int n){
        if(n<=1) return n;
        else return fibonacci(n-1)+fibonacci(n-2);
    }
}
