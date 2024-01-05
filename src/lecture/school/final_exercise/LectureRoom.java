package lecture.school.final_exercise;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class LectureRoom { //이해가 안가!!
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
//        public int compareTo(Time o) { //시작 시간을 기준으로 오름차순
//            if(this.start==o.start) return this.end-o.end;
//            return this.start-o.start;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int n = Integer.parseInt(br.readLine());
//        Time[] arr = new Time[n];
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            int s = Integer.parseInt(st.nextToken());
//            int e = Integer.parseInt(st.nextToken());
//            arr[i] = new Time(s, e);
//        }
//        Arrays.sort(arr);
//
//        // 끝나는 시간만 입력하는 우선순위 큐..
//        PriorityQueue<Integer> pQ = new PriorityQueue<>();
//        pQ.add(arr[0].end);
//
//        for (int i = 1; i < n; i++) {
//            if(pQ.peek() <= arr[i].start) pQ.poll();
//
//            pQ.add(arr[i].end);
//        }
//
//        System.out.println(pQ.size());
//
//    }
//}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class LectureRoom {
//    static class Time implements Comparable<Time>{
//        int start, end;
//
//        public Time(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//
//        @Override
//        public int compareTo(Time o) {
//            if(this.start==o.start) return this.end - o.end;
//            return this.start - o.start;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int n = Integer.parseInt(br.readLine());
//        Time[] arr = new Time[n];
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            int s = Integer.parseInt(st.nextToken());
//            int e = Integer.parseInt(st.nextToken());
//            arr[i] = new Time(s, e);
//        }
//        PriorityQueue<Integer> pQ = new PriorityQueue<>();
//        pQ.add(arr[0].end);
//        for (int i = 1; i < n; i++) {
//            if(arr[i].start >= pQ.peek()) pQ.poll();
//            pQ.add(arr[i].end);
//        }
//        System.out.println(pQ.size());
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LectureRoom {
    static class Time implements Comparable<Time>{
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.start==o.start) return this.end - o.end;
            return this.start - o.start;
        }
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
        //끝나는 시간만 담는 priority queue
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.add(arr[0].end);
        for (int i = 1; i < n; i++) {
            if(arr[i].start>=pQ.peek()) pQ.poll();
            pQ.add(arr[i].end);
        }
        System.out.println(pQ.size());
    }
}