package lecture.school.middle_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExchangeCoin2 {
    static int[] dy;

    public static void exchangeCoin(int[] coin, int price){
        dy = new int[price+1];
        dy[0] = 1;

        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= price; j++) {
                dy[j] += dy[j-coin[i]];
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
            exchangeCoin(coin, price);
        }
    }
}