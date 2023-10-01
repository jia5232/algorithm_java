package lecture.inflearn_basic.array;

import java.util.Scanner;

// 꼭 다시풀어보기!
public class Mentoring {
    public static int solution(int student, int test, int[][] array){
        int answer = 0;
        for (int i = 1; i <= student; i++) {
            for (int j = 1; j <= student; j++) { //(i, j) 학생 쌍 비교
                int cnt = 0;
                for (int k = 0; k < test; k++) {
                    int pi = 0, pj = 0;
                    for (int l = 0; l < student; l++) {
                        if(array[k][l]==i) pi=l; //첫번쨰 학생의 현재 등수
                        if(array[k][l]==j) pj=l; //두번쨰 학생의 현재 등수
                    }
                    if(pi<pj) cnt++; //이번 시험에서 i가 j보다 잘봤으면 카운트 업
                }
                if(cnt==test) answer++; //모든 시험에서 i가 j보다 잘봤으면 (i, j) 조합이 가능하므로 answer 증가!
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int student_num = sc.nextInt();
        int test_num = sc.nextInt();
        int[][] arr = new int[test_num][student_num];
        for (int i = 0; i < test_num; i++) {
            for (int j = 0; j < student_num; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(student_num, test_num, arr));
    }
}
