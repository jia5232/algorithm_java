package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            char[] arr = br.readLine().toCharArray();
            if(isVPS(arr)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static boolean isVPS(char[] arr){
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if(c=='(') stack.push('(');
            else{
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
