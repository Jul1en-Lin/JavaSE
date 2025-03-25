public class Student {
    public int age;

    public Student(int age) {
        this.age = age;
    }

    @Override
    protected Object clone()  {
        try {
            super.clone();
        }catch (CloneNotSupportedException e){
            e.getStackTrace();
            System.out.println("here");
        }
        return 1;
    }
}
