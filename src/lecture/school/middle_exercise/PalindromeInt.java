package lecture.school.middle_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PalindromeInt {
    public static int palindrome(int[] arr, int lt, int rt){
        if(lt>=rt) return 1;

        if(arr[lt]!=arr[rt]) return 0;
        else return palindrome(arr, lt+1, rt-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
            System.out.println(palindrome(arr, 0, n-1));
        }
    }
}