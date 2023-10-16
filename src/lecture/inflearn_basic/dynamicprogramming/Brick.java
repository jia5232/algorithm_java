package lecture.inflearn_basic.dynamicprogramming;

public class Brick implements Comparable<Brick> {
    public int s, h, w;

    public Brick(int s, int h, int w) {
        this.s = s; //넓이
        this.h = h; //높이
        this.w = w; //무게
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s; //넓이 기준 내림차순 정렬!
    }
}
