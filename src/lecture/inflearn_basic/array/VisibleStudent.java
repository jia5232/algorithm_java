package lecture.inflearn_basic.array;

import java.util.Scanner;

public class VisibleStudent {
    public static int solution(int[] array){
        int result = 1;
        int max = array[0];
        for (int i : array) {
            if(i > max){
                result+=1;
                max = i;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr));
    }
}
