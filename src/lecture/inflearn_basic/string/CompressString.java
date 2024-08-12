package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompressString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine()+" ";
        char[] charArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char before = charArr[0];
        sb.append(before);
        int count = 1;
        for (int i = 1; i < charArr.length; i++) {
            char tmp = charArr[i];
            if(tmp==before){
                count++;
            }else{
                if(count>1){
                    sb.append(count);
                    count = 1;
                }
                sb.append(tmp);
                before = tmp;
            }
        }
        System.out.println(sb);
    }
}