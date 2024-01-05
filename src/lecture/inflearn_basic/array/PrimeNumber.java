package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//public class PrimeNumber {
//    public static int solution(int n){
//        int result = 0;
//        int[] arr = new int[n+1];
//        for (int i = 2; i <= n; i++) {//1은 소수가 아니니 거르고 2부터 시작
//            if(arr[i]==0){ //아직 걸러지지 않은 수면 소수 추가
//                result += 1;
//                for (int j = i; j <= n; j=j+i) { //해당 인덱스의 배열값과 그 배수들도 싹다 거름.
//                    arr[j] = 1;
//                }
//            }
//        }
//        return result;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println(solution(sc.nextInt()));
//    }
//}

public class PrimeNumber {
    public static int solution(int n){
        int[] arr = new int[n+1];
        int answer = 0;
        for (int i = 2; i <= n; i++) { //1은 소수가 아니니 거르고 2부터 시작
            if(arr[i]==0){ //아직 걸러지지 않은 수면 소수 추가
                answer++;
                for (int j = i; j <= n; j = j+i) {
                    arr[j] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(solution(num));
    }
}