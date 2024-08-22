package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                stack.push(Integer.parseInt(String.valueOf(c)));
            } else{
                int a = stack.pop();
                int b = stack.pop();
                if(c=='+'){
                    stack.push(a+b);
                }else if(c=='-'){
                    stack.push(b-a);
                }else if(c=='*'){
                    stack.push(a*b);
                }else{
                    stack.push(a/b);
                }
            }
        }
        System.out.println(stack.pop());
    }
}