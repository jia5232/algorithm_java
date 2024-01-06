package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Number[] arr = new Number[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Number(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max < arr[i].index-i){
                max = arr[i].index-i;
            }
        }
        System.out.println(max+1);
    }

    static class Number implements Comparable<Number>{
        int data;
        int index;

        public Number(int data, int index) {
            this.data = data;
            this.index = index;
        }


        @Override
        public int compareTo(Number o) {
            return this.data - o.data;
        }
    }
}
