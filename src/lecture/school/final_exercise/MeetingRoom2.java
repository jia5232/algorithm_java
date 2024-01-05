package lecture.school.final_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoom2 {
    static class Time implements Comparable<Time>{
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) { //끝나는 시간을 기준으로 오름차순
            if(this.end==o.end) return this.start - o.start;
            return this.end-o.end;
        }
    }

    public static int solution(Time[] arr){
        int answer = 0, lastEndTime = 0;
        for (Time time : arr) {
            if(time.start >= lastEndTime){
                answer++;
                lastEndTime = time.end;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Time[] arr = new Time[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Time(s, e);
        }
        Arrays.sort(arr);
        System.out.println(solution(arr));
    }
}
