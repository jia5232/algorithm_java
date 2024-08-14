package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VisibleStudent {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        String[] inputArr = br.readLine().split(" ");
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(inputArr[i]);
        int answer = 1;
        int beforeMax = arr[0];
        for (int i = 1; i < num; i++) {
            if(arr[i]>beforeMax) {
                answer++;
                beforeMax = arr[i];
            }
        }
        System.out.println(answer);
    }
}