package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        char[] arr = br.readLine().toCharArray();
        int answer = 0;
        if(arr[0]=='(') stack.push('(');
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]=='('){
                stack.add('(');
            }
            else{
                if(arr[i-1]=='('){
                    stack.pop();
                    answer += stack.size();
                }
                else{
                    if(!stack.isEmpty()){
                        stack.pop();
                        answer += 1;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
