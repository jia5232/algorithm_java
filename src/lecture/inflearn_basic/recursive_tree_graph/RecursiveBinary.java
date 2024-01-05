package lecture.inflearn_basic.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveBinary {
    public static void recursive(int n){
        if(n/2==0) System.out.print(n%2);
        else{
            recursive(n/2);
            System.out.print(n%2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        recursive(num);
    }
}