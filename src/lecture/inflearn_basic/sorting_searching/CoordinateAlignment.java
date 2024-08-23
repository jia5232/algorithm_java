package lecture.inflearn_basic.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoordinateAlignment {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            points[i] = new Point(a, b);
        }
        Arrays.sort(points);
        for(Point p : points){
            System.out.println(p.x+" "+p.y);
        }
    }
}

class Point implements Comparable<Point>{
    int x;
    int y;

    public Point(int x, int y){
         this.x = x;
         this.y = y;
    }

    @Override
    public int compareTo(Point o){
        if(this.x == o.x){
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}