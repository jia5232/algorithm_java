package lecture.inflearn_basic.stack_queue;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class CraneMachine {
//    public static int solution(int size, int[][] arr, int[] moves){
//        int answer = 0;
//        Stack<Integer> stack = new Stack<>();
//        for (int move : moves) {
//            for (int i = 1; i <= size; i++) {
//                if(arr[i][move]>0){
//                    if(!stack.isEmpty()){
//                        if(stack.peek()==arr[i][move]){
//                            stack.pop();
//                            answer+=2;
//                        }
//                        else stack.push(arr[i][move]);
//                    }
//                    else stack.push(arr[i][move]);
//                    arr[i][move] = 0;
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int size = Integer.parseInt(br.readLine());
//        int[][] arr = new int[size+1][size+1];
//        for (int i = 1; i <= size; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= size; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int movesSize = Integer.parseInt(br.readLine());
//        int[] moves = new int[movesSize];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < movesSize; i++) {
//            moves[i] = Integer.parseInt(st.nextToken());
//        }
//
//        System.out.println(solution(size, arr, moves));
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class CraneMachine {
    public static int solution(int[][] arr, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int i = 1; i < arr.length; i++) {
                if(arr[i][move]!=0) {
                    if(stack.isEmpty()){
                        stack.add(arr[i][move]);
                        arr[i][move] = 0;
                        break;
                    }
                    if(stack.peek()==arr[i][move]){
                        stack.pop();
                        answer+=2;
                        arr[i][move] = 0;
                        break;
                    }
                    stack.add(arr[i][move]);
                    arr[i][move] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num+1][num+1];
        for (int i = 1; i <= num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int moveNum = Integer.parseInt(br.readLine());
        int[] moves = new int[moveNum];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < moveNum; i++) moves[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(arr, moves));
    }
}