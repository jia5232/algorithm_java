package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//public class ClassPresident {
//    public static int solution(int n, int[][] arr){
//        int answer = 0, max=Integer.MIN_VALUE;
//        for (int i = 1; i <= n; i++) {
//            int cnt=0; //i번 학생과 같은 반을 한 j번 학생은 몇명이 있는가?
//            for (int j = 1; j <= n; j++) {
//                for (int k = 1; k <= 5; k++) {
//                    if(arr[i][k] == arr[j][k]){ //i번 학생의 k학년 반과 j번 학생의 k학년 반이 같으면,
//                        cnt++;
//                        break; //한번이라도 같은 반을 헸으면 cnt 하나 올리고 break 해줘야 한다.
//                    }
//                }
//            }
//            if(cnt>max){
//                max = cnt;
//                answer = i;
//            }
//        }
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int[][] arr = new int[num+1][5+1];
//        for (int i = 1; i <= num; i++) {
//            for (int j = 1; j <= 5; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        System.out.println(solution(num, arr));
//    }
//}

public class ClassPresident {
    public static int solution(int n, int[][] arr){
        int answer = 0, max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if(arr[i][k] == arr[j][k]){
                        cnt++;
                        break;
                        //i번 학생과 j번 학생이 한번이라도 같은 반을 했다면 cnt는 한번만 올리고 break해주기!
                    }
                }
            }
            if(max < cnt){
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num+1][5+1];
        for (int i = 1; i <= num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(num, arr));
    }
}