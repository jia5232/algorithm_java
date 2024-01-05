package lecture.inflearn_basic.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestDistance { //최단거리 -> BFS
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch; //방문 여부 체크
    static int[] dis; //해당 노드까지 최소 이동 간선수

    public static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //총 노드의 개수
        m = Integer.parseInt(st.nextToken()); //간선의 개수
        graph = new ArrayList<>(); //노드들의 연결정보를 기록
        ch = new int[n+1]; //방문했는지 여부 체크!
        dis = new int[n+1]; //해당 노드까지 최소 이동 간선수
        for (int i = 0; i <= n; i++) { //정점 노드의 번호를 그대로 쓰기 위해 0~n까지
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        ch[1] = 1; //1번 노드가 출발점이므로 체크!
        dis[1] = 0; //왜?? -> 1이 출발이니까 1까지 최소 이동 간선수는 0이지!
        BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i+" : "+dis[i]);
        }
    }
}