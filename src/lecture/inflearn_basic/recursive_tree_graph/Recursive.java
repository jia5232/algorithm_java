package lecture.inflearn_basic.recursive_tree_graph;

//import java.util.Scanner;
//
//public class Recursive {
//    public static void recursive(int n){
//        if(n==0) return;
//        else{
//            recursive(n-1);
//            System.out.print(n+" ");
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        recursive(num);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive {
    public static void recursive(int n){
        if(n==0) return;
        recursive(n-1);
        System.out.print(n+" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        recursive(num);
    }
}