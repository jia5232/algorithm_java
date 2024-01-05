package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompressString {
    public static String solution(char[] arr){
        String answer = String.valueOf(arr[0]);
        int cnt = 1;
        char tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == tmp) cnt++;
            else{
                if(cnt>1){
                    answer+=cnt;
                    cnt = 1;
                }
                answer += arr[i];
                tmp = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine() + " "; //공백 스트링 하나 붙이기,,
        System.out.println(solution(str.toCharArray()));
    }
}