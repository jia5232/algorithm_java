package lecture.inflearn_basic.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LRU {
    public static int[] solution(int s, int[] tasks){
        int[] cache = new int[s];
        for (int x : tasks) {
            int pos = -1;//인덱스 번호
            for (int i = 0; i < s; i++) if(cache[i]==x) pos = i; //cache hit
            if(pos == -1){ //cache miss -> 맨 뒤에서부터 땡김
                for (int i = s-1; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            else{ //cache hit -> 히트인 곳에서부터 땡김
                for (int i = pos; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) tasks[i] = Integer.parseInt(st.nextToken());
        for (int i : solution(s, tasks)) {
            System.out.print(i+" ");
        }
    }
}