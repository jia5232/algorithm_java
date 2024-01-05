package lecture.school.middle_exercise;

public class PalindromeString {
    public static int palindrome(char[] arr, int lt, int rt){
        if(lt>=rt) return 1;

        if(arr[lt]!=arr[rt]) return 0;
        else return palindrome(arr, lt+1, rt-1);
    }

    public static void main(String[] args) {
        String str = "malayalam";
        System.out.println(palindrome(str.toCharArray(), 0, str.length()-1));
    }
}
