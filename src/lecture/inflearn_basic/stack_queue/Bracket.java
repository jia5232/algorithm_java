package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        String answer = "YES";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='(') stack.push('(');
            else{
                if(stack.isEmpty()) answer = "NO";
                else stack.pop();
            }
        }
        if(!stack.isEmpty()) answer = "NO";
        System.out.println(answer);
    }
}