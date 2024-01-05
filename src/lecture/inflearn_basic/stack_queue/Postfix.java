package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//Character.isDigit(c) -> 이걸로 숫자인지 구분하는게 더 편함!
public class Postfix {
    public static int solution(char[] arr){
        Stack<Integer> stack = new Stack<>();
        for (char c : arr) {
            if(Character.isDigit(c)) stack.add(Character.getNumericValue(c));
            else{
                int b = stack.pop();
                int a = stack.pop();
                int newValue;
                if(c == '+') newValue = a+b;
                else if(c =='-') newValue = a-b;
                else if(c == '*') newValue = a*b;
                else newValue = a/b;
                stack.push(newValue);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str.toCharArray()));
    }
}