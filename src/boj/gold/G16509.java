package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G16509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int sr = Integer.parseInt(inputArr[0]);
        int sc = Integer.parseInt(inputArr[1]);
        inputArr = br.readLine().split(" ");
        int er = Integer.parseInt(inputArr[0]);
        int ec = Integer.parseInt(inputArr[1]);

        int[] dr1 = {-1, 0, 1, 0};     // 상우하좌
        int[] dc1 = {0, 1, 0, -1};     // 상우하좌

        int[] dr2 = {-2, -2, -2, 2, 2, 2, 2, -2};
        int[] dc2 = {-2, 2, 2, 2, 2, -2, -2, -2};


        int[][] ch = new int[10][9];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        ch[sr][sc] = 1;
        boolean isFound = false;
        int level = 0;
        while (!queue.isEmpty()){
            if(isFound) break;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                if(now[0]==er && now[1]==ec){
                    isFound = true;
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int nr1 = now[0] + dr1[j];
                    int nc1 = now[1] + dc1[j];
                    if(nr1>=0 && nr1<10 && nc1>=0 && nc1<9 && !(nr1==er && nc1==ec)){
                        for (int k = j*2; k < j*2+2; k++) {
                            int nr2 = nr1 + dr2[k];
                            int nc2 = nc1 + dc2[k];
                            if(nr2>=0 && nr2<10 && nc2>=0 && nc2<9 && ch[nr2][nc2]==0){
                                int mr = nr1 + dr2[k]/2;
                                int mc = nc1 + dc2[k]/2;

                                if(!(mr==er && mc==ec)){
                                    ch[nr2][nc2] = 1;
                                    queue.add(new int[]{nr2, nc2});
                                }
                            }
                        }
                    }
                }
            }
            if(!isFound) level++;
        }
        if(isFound) System.out.println(level);
        else System.out.println(-1);
    }
}
