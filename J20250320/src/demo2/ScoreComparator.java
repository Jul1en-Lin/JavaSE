package demo2;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.score - o2.score);//精度丢失
    }
}
