package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RemoveBracketString {
    public static String solution(char[] arr){
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for (char c : arr) {
            if(c=='(') stack.add('(');
            else if (c==')' && !stack.isEmpty()) stack.pop();
            else{
                if(stack.isEmpty()) answer+=c;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str.toCharArray()));
    }
}