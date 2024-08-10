package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Position implements Comparable<Position>{
    int y, x, dist;

    public Position(int y, int x, int dist){
        this.y = y;
        this.x = x;
        this.dist = dist;
    }

    @Override
    public int compareTo(Position o){
        if(this.dist != o.dist){
            return Integer.compare(this.dist, o.dist);
        } else if(this.y != o.y){
            return Integer.compare(this.y, o.y);
        } else {
            return Integer.compare(this.x, o.x);
        }
    }
}

public class G16236 {
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        Position cur = null;

        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(inputArr[j]);
                if(arr[i][j]==9){
                    cur = new Position(i, j, 0);
                    arr[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eat = 0; //먹은 물고기 수
        int move = 0; //움직인 총 거리

        while (true){
            PriorityQueue<Position> queue = new PriorityQueue<>();
            boolean[][] visit = new boolean[n][n];

            queue.add(new Position(cur.y, cur.x, 0));
            visit[cur.y][cur.x] = true;

            Position fish = null; //먹을 수 있는 물고기를 담는다

            while (!queue.isEmpty()){
                cur = queue.poll();

                if(arr[cur.y][cur.x] != 0 && arr[cur.y][cur.x] < size){
                    if(fish==null || cur.compareTo(fish)<0){
                        fish = cur; //아직까지 찾은 물고기가 없거나 현재 물고기보다 가까운 물고기를 찾으면 업데이트
                    }
                }

                for(int k=0; k<4; k++){
                    int ny = cur.y + dy[k];
                    int nx = cur.x + dx[k];

                    if(ny>=0 && nx>=0 && ny<n && nx<n && !visit[ny][nx] && arr[ny][nx]<=size){
                        queue.add(new Position(ny, nx, cur.dist + 1));
                        visit[ny][nx] = true;
                    }
                }
            }

            if(fish==null) break;

            cur = fish;
            arr[cur.y][cur.x] = 0;
            eat++;
            move += cur.dist;

            if(eat==size){
                size++;
                eat = 0;
            }
        }
        System.out.println(move);
    }
}
