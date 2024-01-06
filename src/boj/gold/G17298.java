package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class G17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0); //스택에는 인덱스를 넣는다.
        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        for (int i : result) {
            sb.append(i+" ");
        }
        System.out.println(sb);
    }
}
