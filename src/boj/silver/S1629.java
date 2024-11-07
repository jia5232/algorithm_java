package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1629 {
    static long a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        a = Integer.parseInt(inputArr[0]);
        b = Integer.parseInt(inputArr[1]);
        c = Integer.parseInt(inputArr[2]);
        System.out.println(pow(a, b));
    }

    public static long pow(long a, long exponent){
        if(exponent==1){
            return a%c;
        }

        long tmp = pow(a, exponent/2);

        if(exponent%2==1){
            return (tmp * tmp % c) * a % c;
        } else {
            return tmp * tmp % c;
        }
    }
}
