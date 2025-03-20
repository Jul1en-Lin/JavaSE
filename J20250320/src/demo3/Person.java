package demo3;
class Money implements Cloneable/*可拷贝声明*/{
    public double money = 9.9;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Person implements Cloneable/*可拷贝声明*/ {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    Money m = new Money();
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        //浅拷贝
        Person tmp = (Person) super.clone();
        tmp.m = (Money) this.m.clone();
        return tmp;
        //深拷贝
    }
}

