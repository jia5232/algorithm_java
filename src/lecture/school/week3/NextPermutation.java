package lecture.school.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NextPermutation {
    public static void nextPermutation(char[] strArray, int n) {
        if(n <= 1) {
            System.out.println(strArray[0]);
            return;
        }

        int pivotIndex = n - 2;

        while(pivotIndex >= 0) {
            if(strArray[pivotIndex] < strArray[pivotIndex+1]) {
                break;
            }
            pivotIndex--;
        }

        if(pivotIndex < 0) {
            for(int i = n - 1; i >= 0; i--){
                System.out.print((char)strArray[i]);
            }
            System.out.println();
            return;
        }

        int nextIndex = n - 1;

        for(int i=nextIndex; i > pivotIndex; i--) {
            if(strArray[i] > strArray[pivotIndex]) {
                nextIndex = i;
                break;
            }
        }

        char tmp = strArray[nextIndex];
        strArray[nextIndex] = strArray[pivotIndex];
        strArray[pivotIndex] = tmp;

        int start = pivotIndex + 1;
        int end = n - 1;

        while(start < end) {
            char swapTmp = strArray[start];
            strArray[start] = strArray[end];
            strArray[end] = swapTmp;

            start += 1;
            end -= 1;
        }

        for(int value : strArray) {
            System.out.print((char)value);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            nextPermutation(s.toCharArray(), n);
        }
    }
}
