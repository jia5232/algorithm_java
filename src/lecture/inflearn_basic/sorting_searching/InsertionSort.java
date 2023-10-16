package lecture.inflearn_basic.sorting_searching;

import java.util.Scanner;

public class InsertionSort {
    public static int[] solution(int n, int[] arr){
        for (int i = 1; i < n; i++) { //i가 1부터 돈다
            int tmp = arr[i];
            int j; //스코프 밖에서 사용하려고 j를 미리 선언
            for (j = i-1; j >= 0; j--) {
                if(arr[j] > tmp) arr[j+1] = arr[j]; //arr[j]가 tmp보다 크면 한칸 뒤로 밀어준다.
                else break; //그렇지않으면 break하고 arr[j] 바로 뒤에 tmp를 넣어준다.
            }
            arr[j+1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i : solution(n, arr)) System.out.print(i+" ");
    }
}
