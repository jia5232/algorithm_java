package lecture.school.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RapidFibonacci {
    static int[][] unit = {{1, 1}, {1, 0}};
    public static int fibonacci(int n){
        if(n<=1) return 1;
        else{
            int[][] tmp = pow(unit, n-1);
            return tmp[0][0];
        }
    }

    public static int[][] pow(int[][] a, int n){
        if(n==1) return a;

        int[][] half = pow(a, n/2);
        if(n%2==0) return multiply(half, half);
        else return multiply(multiply(half, half), a);
    }

    public static int[][] multiply(int[][] a, int[][] b){
        int[][] newArr = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    newArr[i][j] = (newArr[i][j] + a[i][k]*b[k][j]) % 1000;
                }
            }
        }
        return newArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(fibonacci(n));
        }
    }
}