package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S29754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, int[][]> map = new HashMap<>(); //이름, {인풋 들어온 횟수, 총 시간}

        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);

        int weeks = (m+6) / 7; //전체 주차 수 계산

        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            String name = inputArr[0];

            int day = Integer.parseInt(inputArr[1]);
            int weekIndex = (day - 1) / 7;

            String[] startArr = inputArr[2].split(":");
            String[] endArr = inputArr[3].split(":");

            int startHour = Integer.parseInt(startArr[0]);
            int startMinute = Integer.parseInt(startArr[1]);
            int endHour = Integer.parseInt(endArr[0]);
            int endMinute = Integer.parseInt(endArr[1]);
            int streamMinute = (endHour-startHour)*60 + (endMinute-startMinute);

            if (!map.containsKey(name)) {
                map.put(name, new int[weeks][2]); // 주차별 {방송 횟수, 총 시간} 초기화
            }

            int[][] weekData = map.get(name);
            weekData[weekIndex][0] += 1; // 방송 횟수 증가
            weekData[weekIndex][1] += streamMinute; // 방송 시간 증가
        }

        List<String> real = new ArrayList<>();
        for(String name : map.keySet()){
            int[][] weekData = map.get(name);
            boolean isValid = true;
            for(int i=0; i<weeks; i++){
                if(weekData[i][0]<5 || weekData[i][1]<3600){
                    isValid = false;
                    break;
                }
            }
            if(isValid) real.add(name);
        }

        if(real.isEmpty()){
            System.out.println(-1);
        } else {
            Collections.sort(real);
            for(String name : real){
                System.out.println(name);
            }
        }
    }
}
