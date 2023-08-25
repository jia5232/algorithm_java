package lecture.inflearn_basic.string;

import java.util.Scanner;

public class WordInSentence {
    public static String solution(String str){
        String result = "";
        String[] arr = str.split(" ");
        for(String s : arr){
            if(s.length()>result.length()){
                result = s;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
