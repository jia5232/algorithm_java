package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int test = Integer.parseInt(br.readLine());
        String[] inputArr;
        for(int t=0; t<test; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] persons = new int[n][2];
            for(int i=0; i<n; i++){
                inputArr = br.readLine().split(" ");
                persons[i][0] = Integer.parseInt(inputArr[0]);
                persons[i][1] = Integer.parseInt(inputArr[1]);
            }

            int answer = 1;
            Arrays.sort(persons, (a, b) -> a[0] - b[0]);
            int highestInterviewRank = persons[0][1];

            for(int i=1; i<n; i++){
                if(persons[i][1]<highestInterviewRank){
                    answer++;
                    highestInterviewRank = persons[i][1];
                }
            }
            System.out.println(answer);
        }
    }
}