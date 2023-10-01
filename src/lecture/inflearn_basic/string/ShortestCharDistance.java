package lecture.inflearn_basic.string;

import java.util.Scanner;

public class ShortestCharDistance {
    public static int[] solution(String s, char t){
        int[] answer = new int[s.length()];
        int p = 1000;
        //오른쪽으로 돈다!
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==t){
                p=0;
                answer[i] = p;
            } else{
                p++;
                answer[i] = p;
            }
        }
        p = 1000; //다시 초기화!
        //왼쪽으로 돈다!
        for (int i = s.length()-1; i >= 0 ; i--) {
            if(s.charAt(i)==t) p=0; //다시 배열에 넣어줄 필요는 없다.
            else{
                p++;
                answer[i] = Math.min(answer[i], p); //기존의 값과 p중에 작은 값을 넣는다.
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for(int x : solution(str, c)){
            System.out.print(x+" ");
        }
    }
}
