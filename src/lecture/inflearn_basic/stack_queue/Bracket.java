package lecture.inflearn_basic.stack_queue;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Stack;
//
//public class Bracket {
//    public static boolean solution(String[] arr){
//        Stack<String> stack = new Stack<>();
//        for (String s : arr) {
//            if(s.equals("(")) stack.push("(");
//            else{
//                if(stack.empty()) return false;
//                else stack.pop();
//            }
//        }
//        if(stack.empty()) return true;
//        else return false;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        if(solution(str.split(""))) System.out.println("YES");
//        else System.out.println("NO");
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {
    public static boolean solution(char[] arr){
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if(c=='(') stack.add('(');
            else{
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(solution(str.toCharArray())) System.out.println("YES");
        else System.out.println("NO");
    }
}