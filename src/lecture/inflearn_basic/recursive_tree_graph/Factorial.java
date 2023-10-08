package lecture.inflearn_basic.recursive_tree_graph;

import java.util.Scanner;

public class Factorial {
    public static int factorial(int n){
        if(n==1) return 1;
        else return n*factorial(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(factorial(num));
    }
}
