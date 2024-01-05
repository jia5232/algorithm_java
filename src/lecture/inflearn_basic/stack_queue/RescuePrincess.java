package lecture.inflearn_basic.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RescuePrincess {
    public static int solution(int n, int k){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.add(i+1);
        while (queue.size()>1){
            for (int i = 0; i < k-1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(solution(n, k));
    }
}