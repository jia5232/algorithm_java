package lecture.inflearn_basic.dfs_bfs;

import java.util.*;

//// 2. 강의 풀이 -> Point 클래스 사용
public class DeliveryPizza{

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi; //pz리스트에서 선택된 피자집들의 인덱스 배열
    static ArrayList<Point> hs, pz;
    public static void DFS(int L, int s){
        if(L==m){
            int sum = 0;
            for (Point h : hs) { //집 하나를 기준으로
                int dis = Integer.MAX_VALUE;
                for (int i : combi) { //선택된 피자집들을 돌면서 제일 가까운 피자집과의 거리가 얼마인지 구함!
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x)+Math.abs(h.y - pz.get(i).y));
                }
                //이제 dis는 이 집에서의 가장 가까운 피자집까지의 거리! = 피자 배달거리
                sum+=dis;
            }
            answer = Math.min(answer, sum);
        }
        else{
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if(tmp==1) hs.add(new Point(i, j));
                else if(tmp==2) pz.add(new Point(i, j));
            }
        }
        len = pz.size();
        combi = new int[m];
        DFS(0, 0);
        System.out.println(answer);
    }
}