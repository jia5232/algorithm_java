package lecture.inflearn_basic.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindingCalf {
    static int[] dis = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> Q = new LinkedList<>();

    public static int BFS(int s, int e){
        ch = new int[10001];
        ch[s] = 1; //출발지점에 출발했다고 표시
        Q.add(s); //출발 지점을 큐에 추가
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll(); //큐에서 루트가 될 데이터를 뺴온다.

                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j]; //새로운 방문 지점
                    if(nx==e) return L+1; //새로운 방문지점이 e이면 현재의 레벨+1을 리턴!
                    if(nx>=1 && nx<=10000 && ch[nx]==0){ //nx가 범위안에 들어오고 이전에 방문한적이 없으면
                        ch[nx] = 1; //방문했다고 표시
                        Q.add(nx); //방문하는 위치를 큐에 추가
                    }
                }
            }
            L++; //i for문이 다 돌았으면 해당 레벨의 자식들까지 처리가 완료됨 -> 레벨 증가
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        System.out.println(BFS(s, e));
    }
}