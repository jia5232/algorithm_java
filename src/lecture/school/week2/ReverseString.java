package lecture.school.week2;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            char[] c = str.toCharArray();
            reverse(c, 0, c.length - 1);
            System.out.println(c);
        }
    }

    public static void reverse(char[] c, int k, int n){
        if(k>=c.length/2) return;
        else{
            char tmp = c[k];
            c[k] = c[n];
            c[n] = tmp;
            reverse(c, k+1, n-1);
        }
    }
}
