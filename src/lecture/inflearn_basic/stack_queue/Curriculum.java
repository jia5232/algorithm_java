package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Curriculum {
    public static boolean solution(char[] mandatory, char[] course){
        Queue<Character> mandatoryQ = new LinkedList<>();
        Queue<Character> courseQ = new LinkedList<>();
        for (char c : mandatory) mandatoryQ.add(c);
        for (char c : course) {
            if(mandatoryQ.contains(c)) courseQ.add(c);
        }
        if(mandatoryQ.equals(courseQ)) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mandatory = br.readLine();
        String course = br.readLine();
        if(solution(mandatory.toCharArray(), course.toCharArray())) System.out.println("YES");
        else System.out.println("NO");
    }
}