package lecture.inflearn_basic.recursive_tree_graph;

import java.util.Scanner;

public class Fibonacci {
    static int[] arr; //전역으로 배열 선언. -> 메모리제이션!
    public static int fibonacci(int n){
        if(arr[n]>0) return arr[n]; //만약 이미 구한값이 있으면 다시 구하지 않음.
        if(n<=2) return arr[n] = 1; //두번째항까지는 2
        else return arr[n] = fibonacci(n-2)+fibonacci(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        arr = new int[num+1];
        fibonacci(num);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}