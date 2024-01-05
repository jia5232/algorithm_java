package lecture.inflearn_basic.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class KNum {
    public static int solution(int[] arr, int num, int k){
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < num; i++) {
            for (int j = i+1; j < num; j++) {
                for (int l = j+1; l < num; l++) {
                    treeSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (Integer i : treeSet) {
            cnt++;
            if(cnt==k) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(arr, num, k));
    }
}
