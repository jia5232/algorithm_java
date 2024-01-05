package lecture.inflearn_basic.twopointer_slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//public class SumOfNaturalNumber {
//    // 1. 내 풀이 - two point algorithm
//    public static int solution(int n){
//        int result = 0, sum = 0, lt = 0;
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = i+1;
//        }
//        for (int rt = 0; rt < n; rt++) {
//            sum+=arr[rt];
//            if(sum==n) result++;
//            while (sum>=n){
//                sum-=arr[lt++];
//                if(sum==n) result++;
//            }
//        }
//        return result-1; //rt, lt가 자기 자신(n)일때 제외해줌
//    }
//
//    // 2. 강의 풀이 - two point algorithm -> (n을 2로 나눈 몫)+1 까지만 돌면서 확인해도 된다!
//    public static int solution2(int n){
//        int result = 0, sum = 0, lt = 0;
//        int[] arr = new int[n/2+1];
//        for (int i = 0; i < n/2+1; i++) {
//            arr[i] = i+1;
//        }
//        for (int rt = 0; rt < n/2+1; rt++) {
//            sum+=arr[rt];
//            if(sum==n) result++;
//            while (sum>=n){
//                sum-=arr[lt++];
//                if(sum==n) result++;
//            }
//        }
//        return result;
//    }
//
//    // 3. 강의 풀이 -> 수학적 해결법
//    // 1~15에서 앞에서부터 n개의 수를 빼고, 나머지가 n으로 나누어 떨어지면 가능하다!
//    // ex. 15 - (1+2+3) 3개의 수 = 9이고 9는 3으로 나누어 떨어지므로 가능
//    // ex. 15 - (1+2) 2개의 수 = 12이고 12는 2로 나누어 떨어지므로 가능
//    // ex. 15 - (1+2+3+4+5) 5개의 수 = 0이고 0은 5로 나누어 떨어지므로 가능
//    public static int solution3(int n){
//        int result = 0, cnt = 1;
//        n--;
//        while (n>0){
//            cnt++;
//            n = n-cnt;
//            if(n%cnt==0) result+=1;
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        System.out.println(solution3(num));
//    }
//}

public class SumOfNaturalNumber {
    public static int solution(int n){
        int[] arr = new int[n/2 + 1];
        for (int i = 0; i < n/2 + 1; i++) arr[i] = i+1;
        int answer = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];
            if(sum==n) answer++;
            while (sum>=n){
                sum -= arr[lt++];
                if(sum==n) answer++;
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