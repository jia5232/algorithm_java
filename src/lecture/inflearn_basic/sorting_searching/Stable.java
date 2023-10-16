package lecture.inflearn_basic.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class Stable {
    //해당 거리를 지키면서 배치할 수 있는 말의 마릿수
    public static int count(int[] arr, int dist){
        int cnt = 1; //말의 마리수
        int ep = arr[0]; //end position: 바로 이전에 말을 배치한 위치
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
        int lt = 1;
        int rt = arr[n-1];
        while(lt<=rt){
            int mid = (lt+rt)/2; //가장 가까운 두 말 사이의 거리
            if(count(arr, mid) >= c){ //m보다 더 많은 말을 배치할 수 있으면 거리를 늘려도 되겠다.
                answer = mid;
                lt = mid+1;
            }
            else rt = mid-1; //m보다 배치할 수 있는 말이 적으면 거리를 좀 좁혀야 되겠다.
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(solution(n, c, arr));
    }
}
