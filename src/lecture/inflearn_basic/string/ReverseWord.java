package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            String str = br.readLine();
            String reverseStr = new StringBuilder(str).reverse().toString();
            System.out.println(reverseStr);
        }
    }
}