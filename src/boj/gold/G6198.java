package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        long answer = 0;
        for(int i=0; i<n; i++){
            while (!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            answer += stack.size();
            stack.push(arr[i]);
        }
        System.out.println(answer);
    }
}
