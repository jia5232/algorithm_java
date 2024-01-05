package lecture.school.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestCommonSubsequenceDP {
    static int[][] dy;

    public static int lcs(String s1, String s2, int m, int n){
        if(dy[m][n]!=-1) return dy[m][n];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0 || j==0) dy[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dy[i][j] = dy[i-1][j-1] + 1;
                }
                else dy[i][j] = Math.max(dy[i-1][j], dy[i][j-1]);
            }
        }
        return dy[m][n];
    }

    public static String getLCS(char[] s1Arr, char[] s2Arr, int m, int n){
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i>0 && j>0){
            if(s1Arr[i-1]==s2Arr[j-1]){
                lcs.insert(0, s1Arr[i-1]);
                i--;
                j--;
            }
            else if(dy[i-1][j] > dy[i][j-1]) i--;
            else j--;
        }
        return lcs.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            dy = new int[s1.length()+1][s2.length()+1];
            for (int j = 0; j < dy.length; j++) {
                Arrays.fill(dy[j], -1);
            }
            int resultInt = lcs(s1, s2, s1.length(), s2.length());
            String resultString = getLCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
            System.out.println(resultInt+" "+resultString);
        }
    }
}
