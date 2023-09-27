package lecture.school.week2;

import java.util.Scanner;

public class Euclid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(euclid(a, b));
        }
    }

    public static int euclid(int a, int b){
        if(b==0) return a;
        return euclid(b, a%b);
    }
}
