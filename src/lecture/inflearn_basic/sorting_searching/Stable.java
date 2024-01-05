package lecture.inflearn_basic.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Stable {
    public static int count(int[] arr, int dist){ //해당 거리를 지키면서 배치할 수 있는 말의 마릿수
        int cnt = 1; //배치한 말의 마릿수
        int ep = arr[0]; //이전에 말을 배치한 마구간
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]-ep >= dist){
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }

    public static int solution(int n, int c, int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1, rt = arr[n-1];
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr, mid) >= c){
                answer = mid;
                lt = mid+1;
            }
            else rt = mid-1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] stables = new int[n];
        for (int i = 0; i < n; i++) stables[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(n, c, stables));
    }
}