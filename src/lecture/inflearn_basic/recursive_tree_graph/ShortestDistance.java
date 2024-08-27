package lecture.inflearn_basic.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestDistance { //최단거리 -> BFS
    static int[] ch;
    static int[] dis;
    static Queue<Integer> queue;
    static ArrayList<ArrayList<Integer>> arrayList;
    public static void BFS(){
        int L = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                for(int next : arrayList.get(now)){
                    if(ch[next]==0){
                        ch[next] = 1;
                        dis[next] = L;
                        queue.add(next);
                    }
                }
            }
            L++;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        ch = new int[n+1];
        dis = new int[n+1];
        arrayList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            arrayList.get(a).add(b);
        }
        queue = new LinkedList<>();
        queue.add(1);
        ch[1] = 1;
        BFS();
        for (int i = 2; i <= n; i++) {
            System.out.print(dis[i]+" ");
        }
    }
}