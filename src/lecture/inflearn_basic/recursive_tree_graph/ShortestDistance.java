package lecture.inflearn_basic.recursive_tree_graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestDistance { //최단거리 -> BFS
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch; //방문 여부 체크
    static int[] dis; //해당 노드까지 최소 이동 간선수

    public static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0; //왜??
        queue.add(v);
        while (!queue.isEmpty()){
            int currV = queue.poll();
            for (Integer nextV : graph.get(currV)) {
                if(ch[nextV]==0){ //방문한 적이 없는지 확인
                    ch[nextV] = 1;
                    queue.add(nextV);
                    dis[nextV] = dis[currV]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //총 노드의 개수
        m = sc.nextInt(); //간선의 개수
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) { //정점 노드의 번호를 그대로 쓰기 위해 0~n까지
            graph.add(new ArrayList<>());
        }
        ch = new int[n+1];
        dis = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); //인덱스 a의 arrayList에 b를 추가
        }
        BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i+": "+dis[i]);
        }
    }
}
