package lecture.school.week9;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class LongestCommonSubsequenceMemoization {
//    static int[][] dy;
//
//    public static int lcs(String s1, String s2, int m, int n){
//        if(dy[m][n]!=-1) return dy[m][n];
//
//        if(m==0 || n==0) return dy[m][n] = 0;
//        else if(s1.charAt(m-1) == s2.charAt(n-1)) return dy[m][n] = lcs(s1, s2, m-1, n-1) + 1;
//        else return dy[m][n] = Math.max(lcs(s1, s2, m-1, n), lcs(s1, s2, m, n-1));
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int num = Integer.parseInt(br.readLine());
//        for (int i = 0; i < num; i++) {
//            st = new StringTokenizer(br.readLine());
//            String s1 = st.nextToken();
//            String s2 = st.nextToken();
//            dy = new int[s1.length()+1][s2.length()+1];
//            for (int j = 0; j < dy.length; j++) {
//                Arrays.fill(dy[j], -1);
//            }
//            System.out.println(lcs(s1, s2, s1.length(), s2.length()));
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestCommonSubsequenceMemoization {
    static int[][] dy;

    public static int lcs(String s1, String s2, int m, int n){
        if(dy[m][n]!=-1) return dy[m][n];

        if(m==0 || n==0) return dy[m][n] = 0;
        if(s1.charAt(m-1)==s2.charAt(n-1)) return dy[m][n] = lcs(s1, s2, m-1, n-1)+1;
        else return dy[m][n] = Math.max(lcs(s1, s2, m-1, n), lcs(s1, s2, m, n-1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            dy = new int[s1.length()+1][s2.length()+1];
            for (int j = 0; j < dy.length; j++) {
                Arrays.fill(dy[j], -1);
            }
            System.out.println(lcs(s1, s2, s1.length(), s2.length()));
        }
    }
}