package lecture.inflearn_basic.sorting_searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CoordinateAlignment {
    //Point.java 참조!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);
        //sort할때 Comparable 인터페이스를 통해서 정렬한다.
        //이때 우리가 오버라이딩한 compareTo 메소드를 사용하여 정렬을 한다.
        for (Point o : arr) {
            System.out.println(o.x+" "+o.y);
        }
    }
}
