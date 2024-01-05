package lecture.school.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    public static void reverseString(char[] arr, int lt, int rt){
        if(lt<rt){
            char tmp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = tmp;
            reverseString(arr, lt+1, rt-1);
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            char[] arr = str.toCharArray();
            reverseString(arr, 0, arr.length-1);
            System.out.println(String.valueOf(arr));
        }
    }
}