package lecture.school.final_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCSRecursion {
    public static int lcs(String str1, String str2, int m, int n){
        if(m==0 || n==0) return 0;
        else if(str1.charAt(m-1)==str2.charAt(n-1)) return lcs(str1, str2, m-1, n-1)+1;
        else return Math.max(lcs(str1, str2, m-1, n), lcs(str1, str2, m, n-1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            System.out.println(lcs(str1, str2, str1.length(), str2.length()));
        }
    }
}
