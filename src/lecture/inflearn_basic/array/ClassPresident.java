package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClassPresident {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][5+1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int president = 0, max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) { //i번 학생을 기준으로
            int tmp = 0;
            for (int j = 1; j <= n; j++) { //j번 학생이랑
                if(i==j) continue;
                for (int k = 1; k <= 5; k++) { //k 학년때 같은 반이었느냐
                    if(arr[i][k]==arr[j][k]){
                        tmp++;
                        break;
                    }
                }
            }
            if(tmp>max){
                max = tmp;
                president = i;
            }
        }
        System.out.println(president);
    }
}