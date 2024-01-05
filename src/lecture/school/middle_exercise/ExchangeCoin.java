package lecture.school.middle_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExchangeCoin {
    static int[] dy;

    public static void exchangeCoin(int[] coin, int price){
        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= price; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        System.out.println(dy[price]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int price = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] coin = new int[n];
            for (int j = 0; j < n; j++) coin[j] = Integer.parseInt(st.nextToken());

            dy = new int[price+1];
            Arrays.fill(dy, Integer.MAX_VALUE);
            dy[0] = 0;

            exchangeCoin(coin, price);
        }
    }
}