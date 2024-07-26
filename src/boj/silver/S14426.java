package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S14426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j=1; j<=str.length(); j++){
                set.add(str.substring(0, j));
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if(set.contains(str)) cnt++;
        }
        System.out.println(cnt);
    }
}
