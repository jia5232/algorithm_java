package lecture.school.week2;

import java.util.Scanner;

public class RapidFibonacci {
    static int[][] unit = {{1, 1}, {1, 0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long num = scanner.nextLong();
            System.out.println(fibonacci(num));
        }
    }

    public static long fibonacci(long n) {
        if (n <= 1) {
            return n;
        }
        int[][] result = pow(unit, n - 1);
        return result[0][0];
    }

    public static int[][] pow(int[][] a, long n) {
        if (n == 1) {
            return a;
        }
        int[][] half = pow(a, n / 2);
        if (n % 2 == 0) {
            return multiply(half, half);
        } else {
            return multiply(multiply(half, half), unit);
        }
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j] % 1000) % 1000;                }
            }
        }
        return result;
    }
}
