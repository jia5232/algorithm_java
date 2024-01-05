package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VisibleStudent {
    public static int solution(int[] arr){
        int answer = 1;
        int std = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > std){
                answer++;
                std = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(arr));
    }
}