package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i!=j) dist[i][j] = Integer.MAX_VALUE; //같은 도시사이 거리는 0, 아니면 MAX로 초기화
            }
        }

        String[] inputArr;
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            int c = Integer.parseInt(inputArr[2]);

            if(dist[a][b] > c){
                dist[a][b] = c;
            }
        }

        for (int k = 1; k <= n; k++) { //중간에 거쳐가는 도시
            for (int i = 1; i <= n; i++) { //출발도시
                for (int j = 1; j <= n; j++) { //도착도시
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
                        if(dist[i][j] > dist[i][k]+dist[k][j]){
                            dist[i][j] = dist[i][k]+dist[k][j];
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(dist[i][j]==Integer.MAX_VALUE) System.out.print(0+" ");
                else System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }
}
