package lecture.inflearn_basic.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoom {
    static class Time implements Comparable<Time>{
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end==o.end) return this.start-o.start;
            return this.end-o.end;
        }
    }

    public static int solution(Time[] times){
        int answer = 0;
        int endTime = 0;
        Arrays.sort(times);
        for (Time t : times) {
            if(t.start>=endTime){
                answer++;
                endTime = t.end;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        Time[] times = new Time[num];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(solution(times));
    }
}