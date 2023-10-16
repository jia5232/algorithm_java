package lecture.inflearn_basic.sorting_searching;

import java.util.Scanner;

// 선택정렬: 정렬되지 않은 요소들 중에 가장 작은 요소를 선택해서 index 위치의 값과 바꿔줌
public class SelectionSort {
    public static int[] solution(int n, int[] arr){
        for (int i = 0; i < n-1; i++) { //0 < i < n-1
            int idx = i;
            for (int j = i+1; j < n; j++) { //i+1 < j < n
                if(arr[j] < arr[idx]) idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
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
