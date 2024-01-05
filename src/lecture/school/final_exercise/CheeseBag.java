package lecture.school.final_exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class CheeseBag {
    static class Cheese implements Comparable<Cheese>{
        int volume, cost;

        public Cheese(int volume, int cost) {
            this.volume = volume;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cheese o) {
            return o.cost/o.volume - this.cost/this.volume;
        }
    }

    public static void main(String[] args) {
        ArrayList<Cheese> cheeses = new ArrayList<>();
        cheeses.add(new Cheese(8, 80));
        cheeses.add(new Cheese(1, 50));
        cheeses.add(new Cheese(3, 300));
        cheeses.add(new Cheese(2, 80));
        Collections.sort(cheeses);
        for (Cheese cheese : cheeses) {
            System.out.println(cheese.volume+" "+cheese.cost);
        }
    }
}
