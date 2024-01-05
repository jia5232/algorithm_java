package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CalculateScore {
    public static int solution(int[] arr){
        int answer = 0;
        int nowNum = 0;
        for (int i : arr) {
            if(i==1) answer += ++nowNum;
            else nowNum = 0;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(arr));
    }
}