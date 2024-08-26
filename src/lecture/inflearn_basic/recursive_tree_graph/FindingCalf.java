package lecture.inflearn_basic.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FindingCalf {
    static int[] dis = {1, -1, 5};
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int s = Integer.parseInt(inputArr[0]);
        int e = Integer.parseInt(inputArr[1]);

        int answer = 1;
        ch = new int[10001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        ch[s] = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int next = now + dis[j];
                    if(next==e){
                        System.out.println(answer);
                        return;
                    }
                    if(next>0 && next<=10000 && ch[next]==0){
                        ch[next] = 1;
                        queue.add(next);
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}