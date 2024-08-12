package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String reverseStr = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(reverseStr)) System.out.println("YES");
        else System.out.println("NO");
    }
}