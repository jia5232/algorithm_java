package lecture.inflearn_basic.dfs_bfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ExchangeCoin {
    static int n, m;
    static int answer = Integer.MAX_VALUE;

    public static void DFS(int L, int sum, Integer[] arr){
        if(L>=answer) return; //최소값을 구하는 것이므로 이미 구한 answer보다 더 큰값은 계산하지 않는다.

        if(sum>m) return;

        if(sum==m){
            if(answer>L) answer = L;
        }
        else{
            for (int i = 0; i < n; i++) {
                DFS(L+1, sum+arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //동전의 종류 개수
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());
        //시간복잡도를 위해 arr를 내림차순 정렬!
        //Collections를 사용하려면 기본형 배열이면 안되고 객체형의 배열이어야 한다.
        m = sc.nextInt(); //금액
        DFS(0, 0, arr);
        System.out.println(answer);
    }
}
