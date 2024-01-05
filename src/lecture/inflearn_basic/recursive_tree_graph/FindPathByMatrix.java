package lecture.inflearn_basic.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 인접행렬 사용
public class FindPathByMatrix {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public static void DFS(int v){ //v가 현재 정점!
        if(v==n) answer++; //끝까지 갔으면 경로 하나 생성됨.
        else{
            for (int i = 1; i <= n; i++) {
                if(graph[v][i]==1 && ch[i]==0){ //v 노드에서 i 노드로 갈 수 있고, 이전에 방문한 적은 없어야 함.
                    ch[i] = 1; //방문한다고 체크
                    DFS(i); //v->i로 방문한 것이므로, 이제 i가 출발하는 노드가 되어야 함.
                    ch[i] = 0; //호출이 끝났으면 다시 풀어준다.
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //총 노드의 개수
        m = Integer.parseInt(st.nextToken()); //간선의 개수
        graph = new int[n+1][n+1]; //노드들의 연결정보를 기록
        ch = new int[n+1]; //방문했는지 여부 체크!
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
        ch[1] = 1; //1번 노드가 출발점이므로 체크!
        DFS(1);
        System.out.println(answer);
    }
}