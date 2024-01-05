package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MetalStick {
    public static int solution(char[] arr){
        Stack<Character> stick = new Stack<>();
        int answer = 0;
        if(arr[0]=='(') stick.add('(');
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]=='(') stick.add('(');
            else{
                if(arr[i-1]=='('){ //레이져
                    stick.pop();
                    answer += stick.size();
                }
                else{ //막대기 하나가 끝남.
                    stick.pop();
                    answer += 1;
                }
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