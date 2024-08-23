package lecture.inflearn_basic.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class DuplicateCheck {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(inputArr[i]));
            set.add(Integer.parseInt(inputArr[i]));
        }
        if(arrayList.size()==set.size()) System.out.println("U");
        else System.out.println("D");
    }
}