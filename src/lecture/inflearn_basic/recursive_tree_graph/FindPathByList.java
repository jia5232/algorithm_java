package lecture.inflearn_basic.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//인접 리스트 사용 (정점의 개수가 많아지면 인접 행렬X, 인접 리스트 사용해야 함!)
public class FindPathByList {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static void DFS(int v){//v가 현재 정점!
        if(v==n) answer++; //끝까지 갔으면 경로 하나 생성됨.
        else{
            for (Integer nextV : graph.get(v)) { //v노드에서 갈 수 있는 노드들을 가져옴
                if(ch[nextV]==0){ //아직 방문하지 않았는지 확인!
                    ch[nextV] = 1; //방문한다고 체크
                    DFS(nextV); //v->nextV로 방문한 것이므로 nextV가 다음 v가 된다.
                    ch[nextV] = 0; //호출이 끝나면 다시 풀어용
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
        DFS(1);
        System.out.println(answer);
    }
}