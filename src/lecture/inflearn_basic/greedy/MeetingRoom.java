package lecture.inflearn_basic.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MeetingRoom {
    static class Time implements Comparable<Time>{
        int start;
        int end;

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o){
            if(this.end==o.end) return this.start-o.start;
            else return this.end-o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Time[] times = new Time[n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            int s = Integer.parseInt(inputArr[0]);
            int e = Integer.parseInt(inputArr[1]);
            times[i] = new Time(s, e);
        }
        Arrays.sort(times);
        int answer = 0;
        int lastEndTime = 0;
        for(Time t : times){
            if(lastEndTime<=t.start){
                answer++;
                lastEndTime = t.end;
            }
        }
        System.out.println(answer);
    }
}