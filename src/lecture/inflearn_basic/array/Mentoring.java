package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mentoring {
    public static int solution(int student, int test, int[][] arr){
        int answer = 0;
        for (int i = 1; i <= student; i++) {
            for (int j = 1; j <= student; j++) { //(i, j) 학생 쌍 비교
                int cnt = 0;
                for (int k = 0; k < test; k++) {
                    int pi = 0, pj = 0;
                    for (int l = 0; l < student; l++) {
                        // 현재 비교하는 학생은 i, j학생
                        if(arr[k][l]==i) pi=l; //k번째 테스트에서의 i번 학생의 등수
                        if(arr[k][l]==j) pj=l; //k번째 테스트에서의 j번 학생의 등수
                    }
                    if(pi<pj) cnt++; //이번 시험에서 i가 j보다 잘봤으면 카운트 업!
                }
                //모든 시험에서 i가 j보다 잘봤으면 (i, j) 조합이 가능하므로 answer 증가!
                if(cnt==test) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentNum = Integer.parseInt(st.nextToken());
        int testNum = Integer.parseInt(st.nextToken());
        int[][] arr = new int[testNum][studentNum];
        for (int i = 0; i < testNum; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < studentNum; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(studentNum, testNum, arr));
    }
}