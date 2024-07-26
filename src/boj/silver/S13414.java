package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int k = Integer.parseInt(inputArr[0]);
        int l = Integer.parseInt(inputArr[1]);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < l; i++) {
            String studentId = br.readLine();
            map.remove(studentId);
            map.put(studentId, i);
        }
        int cnt = 0;
        for (String studentId : map.keySet()) {
            if(cnt<k){
                System.out.println(studentId);
                cnt++;
            } else {
                break;
            }
        }
    }
}
