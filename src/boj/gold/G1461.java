package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class G1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();
        int max = 0;

        inputArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(inputArr[i]);
            max = Math.max(max, Math.abs(num));

            if(num>0) plus.add(num);
            else minus.add(Math.abs(num));
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < plus.size(); i++) {
            int tmp = plus.get(i);
            if(i%m==0 && tmp==max) answer += tmp;
            else if(i%m==0) answer += tmp*2;
        }
        for (int i = 0; i < minus.size(); i++) {
            int tmp = minus.get(i);
            if(i%m==0 && tmp==max) answer += tmp;
            else if(i%m==0) answer += tmp*2;
        }
        System.out.println(answer);
    }
}
