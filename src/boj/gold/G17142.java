package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G17142 {
    static int n, m;
    static int[][] lab;
    static ArrayList<int[]> viruses = new ArrayList<>();
    static int minTime = Integer.MAX_VALUE;
    static int emptySpace = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                lab[i][j] = tmp;
                if (tmp == 2) {
                    viruses.add(new int[]{i, j});
                } else if (tmp == 0) {
                    emptySpace++;
                }
            }
        }

        if (emptySpace == 0) {
            System.out.println(0);
        } else {
            chooseViruses(new ArrayList<>(), 0);
            if (minTime == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minTime);
            }
        }
    }

    public static void chooseViruses(ArrayList<int[]> selectedViruses, int start) {
        if (selectedViruses.size() == m) {
            spreadVirus(selectedViruses);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            selectedViruses.add(viruses.get(i));
            chooseViruses(selectedViruses, i + 1);
            selectedViruses.remove(selectedViruses.size() - 1);
        }
    }

    public static void spreadVirus(ArrayList<int[]> selectedViruses) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        int[][] tempLab = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int filledSpaces = 0;

        for (int i = 0; i < n; i++) {
            System.arraycopy(lab[i], 0, tempLab[i], 0, n);
        }

        for (int[] t : selectedViruses) {
            queue.add(new int[]{t[0], t[1], 0});  // 바이러스 시작 위치와 시간을 함께 저장
            visited[t[0]][t[1]] = true;
        }

        int time = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int curTime = current[2];

            for (int j = 0; j < 4; j++) {
                int nextR = r + dr[j];
                int nextC = c + dc[j];

                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !visited[nextR][nextC]) {
                    if (tempLab[nextR][nextC] == 0) {
                        visited[nextR][nextC] = true;
                        queue.add(new int[]{nextR, nextC, curTime + 1});
                        filledSpaces++;
                        time = curTime + 1;
                    } else if (tempLab[nextR][nextC] == 2) {
                        visited[nextR][nextC] = true;
                        queue.add(new int[]{nextR, nextC, curTime + 1});
                    }
                }
            }
        }

        if (filledSpaces == emptySpace) {
            minTime = Math.min(minTime, time);
        }
    }
}
