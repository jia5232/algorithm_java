package lecture.school.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringPermutation {
    static int[] ch;
    static int answer;
    public static void permutation(String s, int sum, int L){
        if(L==s.length()){
            if(sum>0) answer++;
            return;
        }
        else{
            for (int i = 0; i < s.length(); i++) {
                if(ch[i]==0){
                    ch[i] = 1;
                    int sign = 1;
                    if(L%2==1) sign = -1;
                    int tmp = (s.charAt(i) - 'a')*sign;
                    permutation(s, sum+tmp, L+1);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            answer = 0;
            ch = new int[str.length()];
            permutation(str, 0, 0);
            System.out.println(answer);
        }
    }
}