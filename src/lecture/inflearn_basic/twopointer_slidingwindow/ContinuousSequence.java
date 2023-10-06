package lecture.inflearn_basic.twopointer_slidingwindow;

import java.util.Scanner;

// 1. 내 답안 -> 시간초과
// 주어진 N의 범위가 1<=N<=100,000 이므로 O(n^2)으로는 어렵다! -> 이중 for문 불가
// two pointer, sliding window를 통해 O(n^2) -> O(n)으로 풀어야 한다.
//public class ContinuousSequence {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            int tmp = arr[i];
//            for (int j = 1+i; j < n; j++) {
//                tmp += arr[j];
//                if(tmp==m){
//                    result += 1;
//                    break;
//                }
//            }
//        }
//        System.out.println(result);
//    }
//}

// 2. 강의 답안
public class ContinuousSequence{
    public static int solution(int n, int m, int[] arr){
        int answer = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) { //rt를 증가하고,
            sum+=arr[rt]; //arr[rt]를 더하고,
            if(sum==m) answer++; //확인
            while (sum>=m){
                sum-=arr[lt++]; //arr[lt]를 빼주고 lt 증가
                if(sum==m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}