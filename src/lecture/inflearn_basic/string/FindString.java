package lecture.inflearn_basic.string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindString {
    public static int solution(char[] arr, char c){
        int answer = 0;
        for (char c1 : arr) {
            if(c1==c) answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        Character c = br.readLine().toLowerCase().charAt(0);
        System.out.println(solution(str.toCharArray(), c));
    }
}