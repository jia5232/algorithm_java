package lecture.inflearn_basic.string;

import java.util.Scanner;

public class RemoveDuplicatedWord {
    public static void solution(String str){
        String answer = "";
        for (int i=0; i<str.length(); i++){
            if(i==str.indexOf(str.charAt(i))) answer+=str.charAt(i);
            // indexOf()는 해당 문자가 존재하는 제일 앞 인덱스를 반환해준다.
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solution(sc.next());
    }
}
