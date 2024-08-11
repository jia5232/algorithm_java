package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatedWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(characters.contains(str.charAt(i))) continue;
            else characters.add(str.charAt(i));
        }
        String answer = "";
        for(Character c : characters) answer+=c;
        System.out.println(answer);
    }
}