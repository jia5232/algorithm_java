package lecture.inflearn_basic.array;

import java.util.Scanner;

public class Peaks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num+2][num+2];
        int peakNum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i==0 || j==0 || i==arr.length-1 || j==arr.length-1) arr[i][j]=0;
                else arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i!=0 && j!=0 && i!=arr.length-1 && j!=arr.length-1){
                    if(arr[i][j]>arr[i][j-1] && arr[i][j]>arr[i][j+1] && arr[i][j]>arr[i-1][j] && arr[i][j]>arr[i+1][j]){
                        peakNum++;
                    }
                }
            }
        }

        System.out.println(peakNum);
    }
}
