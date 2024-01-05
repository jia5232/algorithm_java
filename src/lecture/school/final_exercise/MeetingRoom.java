package lecture.school.final_exercise;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class MeetingRoom {
//    static class Time implements Comparable<Time>{
//        int start;
//        int end;
//
//        public Time(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        public int compareTo(Time o) {
//            if(this.end==o.end) return this.start-o.start;
//            return this.end-o.end;
//        }
//    }
//
//    public static int solution(Time[] arr){
//        int answer = 0, lastEndTime = 0;
//        for (Time time : arr) {
//            if(time.start>=lastEndTime){
//                answer++;
//                lastEndTime = time.end;
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int t = Integer.parseInt(br.readLine());
//        for (int i = 0; i < t; i++) {
//            st = new StringTokenizer(br.readLine());
//            int n = Integer.parseInt(st.nextToken());
//            Time[] arr = new Time[n];
//            for (int j = 0; j < n; j++){
//                int s = Integer.parseInt(st.nextToken());
//                int e = Integer.parseInt(st.nextToken());
//                arr[j] = new Time(s, e);
//            }
//            Arrays.sort(arr);
//            System.out.println(solution(arr));
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoom {
    static class Time implements Comparable<Time>{
        int start, end;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Time[] arr = new Time[n];
            for (int i = 0; i < n; i++) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                arr[i] = new Time(s, e);
            }
            Arrays.sort(arr);
            int answer = 0, lastEndTime = 0;
            for (Time time : arr) {
                if(time.start>=lastEndTime){
                    answer++;
                    lastEndTime = time.end;
                }
            }
            System.out.println(answer);
        }
    }
}