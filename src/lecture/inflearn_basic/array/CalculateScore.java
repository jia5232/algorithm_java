package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CalculateScore {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        String[] inputArr = br.readLine().split(" ");
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(inputArr[i]);
        int answer = arr[0]==1 ? 1 : 0;
        int tmp = arr[0]==1 ? 2 : 1;
        for (int i = 1; i < num; i++) {
            if(arr[i]==1){
                answer += tmp++;
            } else {
                tmp = 1;
            }
        }
        System.out.println(answer);
    }
}