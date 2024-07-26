package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int answer = 0;
        if(str.charAt(0)=='('){
            stack.add('(');
        }
        for(int i=1; i<str.length(); i++){
            char now = str.charAt(i);
            if(now=='('){
                stack.push('(');
            } else { //')'
                if(stack.isEmpty()) continue;

                if(str.charAt(i-1)=='('){
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
