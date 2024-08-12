package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongPalindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder cleanStr = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char tmp = str.charAt(i);
            if(Character.isAlphabetic(tmp)){
                cleanStr.append(tmp);
            }
        }
        String newStr = cleanStr.toString().toLowerCase();
        String reverseStr = new StringBuilder(newStr).reverse().toString();
        if(newStr.equals(reverseStr)) System.out.println("YES");
        else System.out.println("NO");
    }
}