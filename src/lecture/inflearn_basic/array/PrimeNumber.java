package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] arr = new int[num+1];
        for (int i = 2; i <= num; i++) {
            if(arr[i]==0){
                answer++;
                for (int j = i; j <= num; j+=i) {
                    arr[j] = 1;
                }
            }
        }
        System.out.println(answer);
    }
}