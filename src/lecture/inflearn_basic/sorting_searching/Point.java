package lecture.inflearn_basic.sorting_searching;

public class Point implements Comparable<Point>{ //Point 클래스의 객체를 정렬한다.
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
        // 내림차순으로 하려면 이 순서를 바꾸면 됨
        // o.y - this.y, o.x - this.x 이런식으로
    }
}
