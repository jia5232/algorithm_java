package lecture.inflearn_basic.string;
import java.util.Scanner;

public class ReverseSpecialWord {
    public static void solution(String str){
        String answer;
        char[] charArr = str.toCharArray();
        int lt=0, rt=str.length()-1;
        while (lt<rt){
            if(!Character.isAlphabetic(charArr[lt])) lt++;
            else if(!Character.isAlphabetic(charArr[rt])) rt--;
            else {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(charArr);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solution(sc.next());
    }
}
