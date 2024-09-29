package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class S1325 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int hacking;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            graph.get(b).add(a); //b를 신뢰하는 컴퓨터 a
        }
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<int[]> note = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            hacking = 0;
            ch = new int[n+1];
            DFS(i);
            if(max < hacking){
                max = hacking;
            }
            note.add(new int[]{i, hacking});
        }
        for (int[] tmp : note) {
            if(tmp[1]==max) answer.add(tmp[0]);
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(int i : answer){
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    public static void DFS(int n){
        ch[n] = 1;
        hacking++;
        for(int i : graph.get(n)){
            if(ch[i]==0){
                DFS(i);
            }
        }
    }
}
