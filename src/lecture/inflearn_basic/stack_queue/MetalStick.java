package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MetalStick {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        if(str.charAt(0)=='(') stack.push('(');

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='(') stack.push('(');
            else {
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