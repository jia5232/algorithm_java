package lecture.school.week2;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            System.out.println(fibonacci(num));
        }
    }

    public static int fibonacci(int n){
        if(n<=1) return n;
        else return fibonacci(n-2)+fibonacci(n-1);
    }
}
