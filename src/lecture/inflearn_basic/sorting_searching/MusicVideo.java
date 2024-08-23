package lecture.inflearn_basic.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class MusicVideo {
    public static int count(int size, int[] arr){
        int cnt = 1, now = 0;
        for(int i : arr){
            if(now+i>size){
                cnt++;
                now = i;
            } else {
                now += i;
            }
        }
        return cnt;
    }

    public static int solution(int m, int[] arr){
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int min = rt;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            int c = count(mid, arr);
            if(c<=m){
                min = mid;
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(m, arr));
    }
}