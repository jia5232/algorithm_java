package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class G14698 {
    static final long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] inputArr = br.readLine().split(" ");
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                pq.offer(Long.parseLong(inputArr[i]));
            }

            if(n==1){
                System.out.println(1);
                continue;
            }

            long totalCost = 1;
            while (pq.size()>1){
                long newSlime = pq.poll()*pq.poll();
                pq.offer(newSlime);
                totalCost = (totalCost * (newSlime%mod)) % mod;
            }
            System.out.println(totalCost);
        }
    }
}
