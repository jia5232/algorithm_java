package lecture.inflearn_basic.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class MusicVideo {
    public static int count(int[] arr, int capacity){ //해당 용량으로 처리할 수 있는 최소 장수
        int cnt = 1; //DVD 장수
        int sum = 0; //DVD에 담아내는 곡들의 합
        for (int i : arr) {
            if(sum+i > capacity){
                cnt++;
                sum = i;
            }
            else sum += i;
        }
        return cnt;
    }

    public static int solution(int m, int[] arr){
        int answer = 0;
        //배열에서 최대,최솟값 찾는 법 -> optional int 타입 반환하므로 getAsInt()로 캐스팅 필요함.
        int lt = Arrays.stream(arr).max().getAsInt();
        //배열의 전체 합 찾는 법 -> 일반 int 반환하므로 캐스팅 필요 없음.
        int rt = Arrays.stream(arr).sum();
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr, mid) <= m){ //필요한 DVD 장수가 m보다 작거나 같다면 DVD 용량을 줄여봐도 되는거니까!
                answer = mid;
                rt = mid-1;
            }
            else lt = mid+1; //필요한 DVD 장수가 m보다 크다면 DVD 용량을 늘려야 하는거니까!
        }
        return answer;
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