package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScissorRockPaper {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][num];
        String[] inputArr = br.readLine().split(" ");
        for (int i = 0; i < num; i++) arr[0][i] = Integer.parseInt(inputArr[i]);
        inputArr = br.readLine().split(" ");
        for (int i = 0; i < num; i++) arr[1][i] = Integer.parseInt(inputArr[i]);
        for (int i = 0; i < num; i++) {
            int a = arr[0][i], b = arr[1][i];
            if(a==b) System.out.println("D");
            else if((a==1&&b==2) || (a==2&&b==3) || (a==3&&b==1)) System.out.println("B");
            else System.out.println("A");
        }
    }
}