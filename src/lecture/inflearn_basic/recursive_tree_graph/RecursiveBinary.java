package lecture.inflearn_basic.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveBinary {
    public static String recursive(int n, String s){
        if(n==0) return s;
        s += n%2;
        return recursive(n/2, s);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String answer = new StringBuilder(recursive(n, "")).reverse().toString();
        System.out.println(answer);
    }
}