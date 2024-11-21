package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class S16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        long a = Long.parseLong(inputArr[0]);
        long b = Long.parseLong(inputArr[1]);
        Queue<Long> queue = new LinkedList<>();
        Set<Long> set = new HashSet<>();
        int answer = 1;
        queue.add(a);
        set.add(a);
        boolean found = false;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long now = queue.poll();

                if(now==b){
                    found = true;
                    break;
                }

                if(now>b) continue;

                long next1 = now*2;
                long next2 = now*10+1;

                if(!set.contains(next1)){
                    set.add(next1);
                    queue.add(next1);
                }
                if(!set.contains(next2)){
                    set.add(next2);
                    queue.add(next2);
                }
            }
            if(!found)answer++;
        }
        if(found) System.out.println(answer);
        else System.out.println(-1);
    }
}
