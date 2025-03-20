package demo2;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void bubble(Comparable[] comparables){
        for (int i = 0; i <comparables.length - 1 ; i++) {
            for (int j = 0; j < comparables.length - 1 -i; j++) {
                if (comparables[j].compareTo(comparables[j+1]) > 0) {
                    Comparable tmp = comparables[j];
                    comparables[j] = comparables[j+1];
                    comparables[j+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(10,"博哥",80.2);
        students[1] = new Student(13,"鹏哥",90.6);
        students[2] = new Student(11,"梦云",88);
        NameComparator nameComparator = new NameComparator();
        Arrays.sort(students,nameComparator);
        System.out.println(Arrays.toString(students));
        System.out.println("=========");
        bubble(students);
        System.out.println(Arrays.toString(students));
    }
    public static void main2(String[] args) {
        Student student1= new Student(10,"博哥",80.2);
        Student student2 = new Student(13,"鹏哥",90.6);
        NameComparator nameComparator = new NameComparator();
        int ret = nameComparator.compare(student1,student2);
        System.out.println(ret);
        ScoreComparator scoreComparator = new ScoreComparator();
        ret = scoreComparator.compare(student1,student2);
        System.out.println(ret);
    }
    public static void main1(String[] args) {
        Student student1= new Student(10,"博哥",80.2);
        Student student2 = new Student(13,"鹏哥",90.6);
        int ret = student1.compareTo(student2);
        if (ret > 0) {
            System.out.println("s1 > s2");
        }else{
            System.out.println("s1 < s2");
        }
    }
}
