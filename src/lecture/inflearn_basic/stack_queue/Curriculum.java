package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Curriculum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        Queue<Character> queue1 = new LinkedList<>();
        Queue<Character> queue2 = new LinkedList<>();
        for (char c : str1.toCharArray()){
            queue1.offer(c);
        }
        for (char c : str2.toCharArray()){
            if(queue1.contains(c)) queue2.offer(c);
        }
        if(queue1.equals(queue2)) System.out.println("YES");
        else System.out.println("NO");
    }
}