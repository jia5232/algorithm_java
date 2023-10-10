package lecture.inflearn_basic.dfs_bfs;

import java.util.*;

// 1. 내 풀이 -> 오답
// solution 메서드 내에서 combi 배열을 사용하여 모든 피자 조합을 생성할 때, combi 배열 초기화 오류
//public class DeliveryPizza {
//    int[] dr = {-1, 0, 1, 0};
//    int[] dc = {0, 1, 0, -1};
//
//    static int n;
//    static int m;
//    static int[][] board;
//    static int answer = Integer.MAX_VALUE; //최소값을 구한다.
//    static List<int[]> pizza = new ArrayList<>();
//    static List<int[]> house = new ArrayList<>();
//    static List<int[][]> selectedPizza = new ArrayList<>();
//
//    static int[][] combi;
//
//    public static void result(){
//        for (int i = 0; i < house.size(); i++) {
//            int[] houseSpace = house.get(i);
//            int house_x = houseSpace[0];
//            int house_y = houseSpace[1];
//            int sum = 0;
//            for (int j = 0; j < selectedPizza.size(); j++) {
//                int dis = Integer.MAX_VALUE;
//                int[][] selectedPizzaSpaces = selectedPizza.get(j);
//                for (int k = 0; k < m; k++) {
//                    int[] selectedPizzaSpace = selectedPizzaSpaces[k];
//                    int pizza_x = selectedPizzaSpace[0];
//                    int pizza_y = selectedPizzaSpace[1];
//                    dis = Math.min(dis, Math.abs(house_x-pizza_x)+Math.abs(house_y-pizza_y));
//                }
//                sum+=dis;
//            }
//            answer = Math.min(answer, sum);
//        }
//    }
//
//    public static void combination(int L, int s){
//        if(L==m){
//            int[][] tmp = new int[m][2];
//            int t = 0;
//            for (int[] ints : combi) {
//                tmp[t++] = new int[] {ints[0], ints[1]};
//            }
//            selectedPizza.add(tmp);
//        }
//        else{
//            for (int i = s; i < pizza.size(); i++) {
//                combi[L][0] = pizza.get(i)[0]; //선택된 피자집의 x좌표
//                combi[L][1] = pizza.get(i)[1]; //선택된 피자집의 y좌표
//                combination(L+1, i+1);
//            }
//        }
//    }
//
//    public static void solution(int[][] board){
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <n; j++) {
//                if(board[i][j]==1) house.add(new int[] {i, j});
//                if(board[i][j]==2) pizza.add(new int[] {i, j});
//            }
//        }
//        combi = new int[m][2]; //선택된 피자집의 좌표를 담음
//        combination(0, 0);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        board = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                board[i][j] = sc.nextInt();
//            }
//        }
//        solution(board);
//        result();
//        System.out.println(answer);
//    }
//}

//// 2. 강의 풀이 -> Point 클래스 사용
public class DeliveryPizza{
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