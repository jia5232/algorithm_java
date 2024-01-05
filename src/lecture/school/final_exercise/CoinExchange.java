package lecture.school.final_exercise;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class CoinExchange {
//    static int[] coins = {1000, 500, 100, 50, 10, 5, 1};
//
//    public static int solution(int p){
//        int answer = 0, price = p;
//        for (int coin : coins) {
//            while(price>=coin){
//                answer++;
//                price-=coin;
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        for (int i = 0; i < t; i++) {
//            int p = Integer.parseInt(br.readLine());
//            System.out.println(solution(p));
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinExchange {
    static int[] coins = {1000, 500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            int answer = 0;
            int p = Integer.parseInt(br.readLine());
            for (int i = 0; i < coins.length; i++) {
                while (p>=coins[i]){
                    answer++;
                    p -= coins[i];
                }
            }
            System.out.println(answer);
        }
    }
}