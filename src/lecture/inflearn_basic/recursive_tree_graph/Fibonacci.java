package lecture.inflearn_basic.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    static int[] arr;

    public static int fibonacci(int n){
        if(arr[n] > 0) return arr[n];
        if(n<=2) return arr[n] = 1;
        else return arr[n] = fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        fibonacci(n);
        for (int i = 1; i <= n; i++) {
            System.out.println(arr[i]+" ");
        }
    }
}