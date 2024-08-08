package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G15686 {
    static class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, len, answer = Integer.MAX_VALUE;
    static ArrayList<Point> ck, hs;
    static int[] combi;

    public static void DFS(int L, int s){
        if(L==m){
            int sum = 0;
            for(Point h : hs){
                int min = Integer.MAX_VALUE;
                for(int p : combi){
                    min = Math.min(min, Math.abs(h.x - ck.get(p).x) + Math.abs(h.y - ck.get(p).y));
                }
                sum += min; //도시의 피자 배달 거리
            }
            answer = Math.min(answer, sum);
        } else{
            for(int i=s; i<len; i++){
                combi[L] = i;
                DFS(L+1, s+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        ck = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(inputArr[j]);
                if(tmp==1) hs.add(new Point(i, j));
                else if(tmp==2) ck.add(new Point(i, j));
            }
        }
        len = ck.size();
        combi = new int[m];
        DFS(0, 0);
        System.out.println(answer);
    }
}
