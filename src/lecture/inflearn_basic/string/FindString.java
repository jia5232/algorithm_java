package lecture.inflearn_basic.string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        String s = br.readLine();
        int answer = 0;
        for (int i = 0; i < str.length; i++) {
            if(str[i].equalsIgnoreCase(s)) answer++;
        }
        System.out.println(answer);
    }
}