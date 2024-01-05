package lecture.inflearn_basic.twopointer_slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CombineArray {
    public static void solution(int n, int m, int[] arrA, int[] arrB){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1<n && p2<m){
            if(arrA[p1] < arrB[p2]) answer.add(arrA[p1++]);
            else answer.add(arrB[p2++]);
        }
        while (p1<n) answer.add(arrA[p1++]);
        while (p2<m) answer.add(arrB[p2++]);

        for (Integer i : answer) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arrA[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) arrB[i] = Integer.parseInt(st.nextToken());

        solution(n, m, arrA, arrB);
    }
}