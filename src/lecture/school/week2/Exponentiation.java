package lecture.school.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exponentiation {
    public static int exponentiation(int a, int n){
        if(n==0) return 1;
        if(n==1) return a;

        int half = exponentiation(a, n/2);
        if(n%2==0) return (half*half)%1000;
        else return (half*half*a)%1000;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(exponentiation(a, n));
        }
    }
}