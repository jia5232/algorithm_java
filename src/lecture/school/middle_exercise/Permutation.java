package lecture.school.middle_exercise;

public class Permutation {
    static int[] ch;
    static char[] pm;

    public static void permutation(char[] arr, int L){
        if(L==arr.length){
            System.out.println(String.valueOf(pm));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(ch[i]==0){
                ch[i] = 1;
                pm[L] = arr[i];
                permutation(arr, L+1);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        ch = new int[str.length()];
        pm = new char[str.length()];
        permutation(str.toCharArray(), 0);
    }
}