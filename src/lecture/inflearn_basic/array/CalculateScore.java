package lecture.inflearn_basic.array;

import java.util.Scanner;

public class CalculateScore {
    public static int solution(int[] array){
        int result = 0, cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]==1){
                result += ++cnt;
            }
            else cnt=0;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr));
    }
}
