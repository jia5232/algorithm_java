package lecture.inflearn_basic.twopointer_slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CommonElement {
    public static void solution(int n, int m, int[] a, int[] b){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int p1 = 0, p2 = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while (p1<n && p2<m){
            if(a[p1] == b[p2]) arrayList.add(a[p1++]);
            else if(a[p1] < b[p2]) p1++;
            else p2++;
        }
        for (Integer i : arrayList) {
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