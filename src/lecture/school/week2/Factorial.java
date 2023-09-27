package lecture.school.week2;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            System.out.println(factorial(n) % 1000);
        }
    }

    private static Long factorial(int n){
        if(n==0) return 1L;
        else{
            Long tmp = n*factorial(n-1);
            while (tmp%10 == 0){
                tmp/=10;
            }
            return tmp%100000000;
        }
    }
}
