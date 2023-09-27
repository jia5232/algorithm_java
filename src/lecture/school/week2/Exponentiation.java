package lecture.school.week2;

import java.util.Scanner;

public class Exponentiation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int a = scanner.nextInt();
            long b = scanner.nextLong();
            System.out.println(pow(a, b));
        }
    }

    public static long pow(int a, long n){
        if(n==0) return 1;
        else if(n==1) return a;
        long half = pow(a, n/2);
        if(n%2==0){
            return multiply(half, half) % 1000;
        } else{
            return multiply(multiply(half, half), a) % 1000;
        }
    }

    public static long multiply(long a, long b){
        return a*b;
    }

}
