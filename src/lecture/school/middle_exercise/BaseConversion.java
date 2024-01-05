package lecture.school.middle_exercise;

public class BaseConversion {
    public static void baseConversion(int n, int base){
        String[] baseTable = "01234567890abcdef".split("");
        if(n>=base) baseConversion(n/base, base);
        System.out.print(baseTable[n%base]);
    }

    public static void main(String[] args) {
        baseConversion(16, 16);
    }
}
