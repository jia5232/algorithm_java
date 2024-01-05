package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 1. 내 풀이
//public class Palindrome {
//    public static void solution(String str){
//        char[] charArr = str.toCharArray();
//        for (int i = 0; i < charArr.length; i++) {
//            // 65~90이 대문자, 97~122가 소문자!
//            if(charArr[i]>=65 && charArr[i]<=90){
//                charArr[i]+=32;
//            }
//        }
//        //str = str.toLowerCase(); 하면 끝나는데 너 머하고있니..
//        System.out.println(palindrome(charArr));
//    }
//
//    public static String palindrome(char[] arr){
//        for (int i = 0; i < arr.length/2; i++) {
//            if(arr[i]!=arr[arr.length-1-i]) return "NO";
//        }
//        return "YES";
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        solution(sc.next());
//    }
//}

// 2. 강의 풀이
//public class Palindrome {
//    public static String solution(String str){
//        String answer = "NO";
//        String tmp = new StringBuilder(str).reverse().toString();
//        if(str.equalsIgnoreCase(tmp)) answer = "YES";
//        //equalsIgnoreCase -> 대소문자 무시하고 같은지 비교
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println(solution(sc.next()));;
//    }
//}

public class Palindrome {
    public static boolean solution(String str){
        String newStr = str.toLowerCase();
        int lt = 0, rt = str.length()-1;
        while (lt<rt){
            if(newStr.charAt(lt) != newStr.charAt(rt)) return false;
            lt++;
            rt--;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(solution(str)) System.out.println("YES");
        else System.out.println("NO");
    }
}