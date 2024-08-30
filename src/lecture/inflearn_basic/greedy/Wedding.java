package lecture.inflearn_basic.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Wedding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] timeTable = new int[73];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            int c = Integer.parseInt(inputArr[0]);
            int g = Integer.parseInt(inputArr[1]);
            for (int j = c; j < g; j++) {
                timeTable[j]++;
            }
        }
        System.out.println(Arrays.stream(timeTable).max().getAsInt());
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.StringTokenizer;
//
//public class Wedding{
//    static class Time implements Comparable<Time>{
//        int time;
//        char state;
//
//        public Time(int time, char state) {
//            this.time = time;
//            this.state = state;
//        }
//
//        @Override
//        public int compareTo(Time o) {
//            if(this.time==o.time) return this.state-o.state;
//            else return this.time-o.time;
//        }
//    }
//
//    public static int solution(ArrayList<Time> arrayList){
//        int answer = Integer.MIN_VALUE;
//        int cnt = 0;
//        for (Time time : arrayList) {
//            if(time.state=='s') cnt++;
//            else cnt--;
//            answer = Math.max(answer, cnt);
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int num = Integer.parseInt(br.readLine());
//        ArrayList<Time> arrayList = new ArrayList<>();
//        for (int i = 0; i < num; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            arrayList.add(new Time(a, 's'));
//            arrayList.add(new Time(b, 'e'));
//        }
//        Collections.sort(arrayList);
//        System.out.println(solution(arrayList));
//    }
//}