package lecture.inflearn_basic.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumIncome {
    static class Request implements Comparable<Request>{
        int day;
        int money;

        public Request(int day, int money){
            this.day = day;
            this.money = money;
        }

        @Override
        public int compareTo(Request o){
             return this.day-o.day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputArr;
        ArrayList<Request> requests = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            int m = Integer.parseInt(inputArr[0]);
            int d = Integer.parseInt(inputArr[1]);
            requests.add(new Request(d, m));
        }
        Collections.sort(requests);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;


        System.out.println(answer);
    }
}