package lecture.inflearn_basic.twopointer_slidingwindow;

import java.util.Scanner;

// 1. 내 답안 -> 시간초과
//public class MaximumSales {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int days = sc.nextInt();
//        int num = sc.nextInt();
//        int maximumSales = 0;
//        int[] dayArr = new int[days];
//        for (int i = 0; i < days; i++) {
//            dayArr[i] = sc.nextInt();
//        }
//        for (int i = 0; i < days-num+1; i++) {
//            int tmp = 0;
//            for (int j = i; j < i+num; j++) {
//                tmp+=dayArr[j];
//            }
//            if(tmp>maximumSales) maximumSales = tmp;
//        }
//        System.out.println(maximumSales);
//    }
//}

// 2. 강의 답안
public class MaximumSales{
    public static int solution(int days, int num, int[] arr){
        int answer, sum = 0;
        for (int i = 0; i < num; i++) sum+=arr[i]; //첫번째 윈도우 더해놓기
        answer = sum;
        for (int i = num; i < days; i++) { //윈도우 쭉 밀고나가기
            sum += (arr[i]-arr[i-num]); //앞의 요소 하나 빼고 뒤의 요소 하나 더하기
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int num = sc.nextInt();
        int[] dayArr = new int[days];
        for (int i = 0; i < days; i++) {
            dayArr[i] = sc.nextInt();
        }
        System.out.println(solution(days, num, dayArr));
    }

}