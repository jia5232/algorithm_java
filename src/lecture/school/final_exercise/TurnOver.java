package lecture.school.final_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TurnOver {
    public static int solution(char[] arr){
        int one = 0, zero = 0;
        char prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]!=prev){
                if(arr[i]=='1') one++;
                else zero++;
            }
            prev = arr[i];
        }
        return Math.min(one, zero);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str.toCharArray()));
    }
}
