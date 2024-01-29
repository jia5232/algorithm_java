package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G3107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split(":");
        StringBuilder sb = new StringBuilder();
        int bunch = strArr.length; //총 몇개 묶음인지
        for (int i = 0; i < strArr.length; i++) {
            if(strArr[i].length()==0){
                bunch--;
            }
        }

        int nowBunch = 0; //지금 몇번째 묶음을 확인하고 있는지
        int index = 0; //strArr에서 확인할 인덱스
        while (index < strArr.length){
            if(strArr[index].length()==0 && bunch<8){
                sb.append("0000:");
                bunch++;
                nowBunch++;
            } else if (strArr[index].length()==0) { //bunch가 8이 됐으면 인덱스를 뒤로 넘긴다.
                index++;
            } else if(strArr[index].length()!=0){
                for (int j = 0; j < 4 - strArr[index].length(); j++) {
                    sb.append("0");
                }
                sb.append(strArr[index++]);
                nowBunch++;
                if(nowBunch<8){
                    sb.append(":");
                }
            }
        }
        while (nowBunch<8){
            sb.append("0000");
            nowBunch++;
            if(nowBunch<8) sb.append(":");
        }
        System.out.println(sb);
    }
}
