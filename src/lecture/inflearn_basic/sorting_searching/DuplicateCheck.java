package lecture.inflearn_basic.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DuplicateCheck {
    public static boolean isDuplicated(int[] arr){
        Arrays.sort(arr);
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(prev==arr[i]) return true;
            prev = arr[i];
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());
        if(isDuplicated(arr)) System.out.println("D");
        else System.out.println("U");
    }
}