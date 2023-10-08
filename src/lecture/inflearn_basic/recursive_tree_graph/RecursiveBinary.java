package lecture.inflearn_basic.recursive_tree_graph;

import java.util.Scanner;

public class RecursiveBinary {
    public static void recursiveBinary(int n){
        if(n/2==0) System.out.print(n%2);
        else {
            recursiveBinary(n/2);
            System.out.print(n%2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        recursiveBinary(num);
    }
}
