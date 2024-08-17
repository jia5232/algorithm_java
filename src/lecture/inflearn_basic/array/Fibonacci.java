package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < num; i++) {
            arr[i] = arr[i-2]+arr[i-1];
        }
        for (int i = 0; i < num; i++) System.out.print(arr[i]+" ");
    }
}