package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1816 {
    public static boolean available(Long l){
        for (int i = 2; i <= 1000000; i++) {
            if(l%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            if(available(Long.parseLong(br.readLine()))) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
