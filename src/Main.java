import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int n, l, r;
    static int[][] population;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        l = Integer.parseInt(inputArr[1]);
        r = Integer.parseInt(inputArr[2]);
        population = new int[n][n];
        for(int i=0; i<n; i++){
            inputArr = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                population[i][j] = Integer.parseInt(inputArr[j]);
            }
        }

        int days = 0; //인구 이동이 발생한 날의 수
        while (true){
            visited = new boolean[n][n];
            boolean movementOccurred = false;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j]){
                        int unionPopulation = bfs(i, j); //연합 형성, 인구 재분배하고 연합 내 나라의 수 리턴
                        if(unionPopulation > 0){
                            movementOccurred = true; //인구이동이 발생함
                        }
                    }
                }
            }
            if(!movementOccurred) break; //인구이동이 더이상 발생하지 않으면 종료
            days++;
        }
        System.out.println(days);
    }

    public static int bfs(int x, int y){
        List<int[]> union = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        union.add(new int[]{x, y});

        int totalPopulation = population[x][y];
        int countriesCount = 1;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]){
                    int popDiff = Math.abs(population[cx][cy] - population[nx][ny]);
                    if(popDiff >= l && popDiff <= r){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        totalPopulation += population[nx][ny];
                        countriesCount++;
                    }
                }
            }
        }

        if(countriesCount == 1){
            return 0; //연합이 형성되지 않음
        }

        int newPopulation = totalPopulation / countriesCount;
        for(int[] country : union){
            population[country[0]][country[1]] = newPopulation;
        }
        return countriesCount;
    }
}