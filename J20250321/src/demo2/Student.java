package demo2;

import java.util.Objects;

public class Student {
    public String ID;

    public Student(String ID) {
        this.ID = ID;
    }

   /* @Override
    *//*public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(ID, student.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }*/

    public boolean equals(Object obj) {
        Student tmp = (Student) obj;
        if (this.ID.equals(tmp.ID)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
