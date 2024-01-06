package boj.silver;

import java.io.*;
import java.util.Stack;

public class S1874 { //스택 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        int num = 1;
        boolean result = true;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(arr[i]>=num){
                while (arr[i]>=num){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else{
                int popValue = stack.pop();
                if(popValue>arr[i]){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else{
                    sb.append("-\n");
                }
            }
        }
        if(result) System.out.println(sb);
    }
}
