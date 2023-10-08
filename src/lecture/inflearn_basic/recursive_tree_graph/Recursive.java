package lecture.inflearn_basic.recursive_tree_graph;

import java.util.Scanner;

public class Recursive {
    public static void recursive(int n){
        if(n==0) return;
        else{
            recursive(n-1);
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        recursive(num);
    }
}
