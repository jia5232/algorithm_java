package lecture.inflearn_basic.twopointer_slidingwindow;

import java.util.Scanner;

// 꼭 다시 풀기!
public class LongContinuousSequence {
    public static int solution(int n, int k, int[] arr){
        int answer = 0;
        int cnt = 0; //0을 1로 바꾼 횟수
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if(arr[rt]==0) cnt++;
            while (cnt>k){
                if(arr[lt]==0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int chance = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(num, chance, arr));
    }
}
