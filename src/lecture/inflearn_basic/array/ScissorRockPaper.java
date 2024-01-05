package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ScissorRockPaper {
    public static void solution(int num, int[] arrA, int[] arrB){
        for (int i = 0; i < num; i++) {
            if(arrA[i] == arrB[i]) System.out.println("D");
            else if(arrA[i]==1 && arrB[i]==2) System.out.println("B");
            else if(arrA[i]==2 && arrB[i]==3) System.out.println("B");
            else if(arrA[i]==3 && arrB[i]==1) System.out.println("B");
            else System.out.println("A");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arrA = new int[num];
        int[] arrB = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) arrA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) arrB[i] = Integer.parseInt(st.nextToken());
        solution(num, arrA, arrB);
    }
}