package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] segments = br.readLine().split("-");
        int min = sumOfSegment(segments[0]);
        for (int i = 1; i < segments.length; i++) {
            min -= sumOfSegment(segments[i]);
        }
        System.out.println(min);
    }

    public static int sumOfSegment(String str){
        int sum = 0;
        String[] numbers = str.split("\\+");
        for(String number : numbers){
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
