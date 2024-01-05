package lecture.inflearn_basic.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MaximumIncome {
    static int n, max = Integer.MIN_VALUE;

    static class Lecture implements Comparable<Lecture> {
        public int money;
        public int time;

        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture ob) {
            return ob.time - this.time;
        }
    }

    public static int solution(ArrayList<Lecture> arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        Collections.sort(arr);
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if(arr.get(j).time < i) break;
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr.add(new Lecture(m, d));
            if(d>max) max = d;
        }
        System.out.println(solution(arr));
    }
}