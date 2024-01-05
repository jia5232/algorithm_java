package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ExchangeCoin {
    static int n, price;
    static int answer = Integer.MAX_VALUE;

    public static void DFS(int sum, int L, Integer[] coins){
        if(L>=answer) return;

        if(sum>price) return;

        if(sum==price){
            if(answer>L) answer = L;
        }
        else{
            for (int i = 0; i < coins.length; i++) {
                DFS(sum+coins[i], L+1, coins);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Integer[] coins = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(coins, Collections.reverseOrder());
        //시간복잡도를 위해 arr를 내림차순 정렬!
        //Collections를 사용하려면 기본형 배열이면 안되고 객체형의 배열이어야 한다.
        price = Integer.parseInt(br.readLine());
        DFS(0, 0, coins);
        System.out.println(answer);
    }
}