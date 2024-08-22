package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CraneMachine {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        int m = Integer.parseInt(br.readLine());
        inputArr = br.readLine().split(" ");
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(inputArr[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            for (int j = 0; j < n; j++) {
                int doll = board[j][move-1];
                if(doll!=0){
                    if(!stack.isEmpty()){
                        if(stack.peek()==doll){
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(doll);
                        }
                    }else{
                        stack.push(doll);
                    }
                    board[j][move-1] = 0;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}