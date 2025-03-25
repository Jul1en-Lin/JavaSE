public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        try {
            testClass testClass = new testClass();
            testClass.toString();
            testClass.clone();
        } catch (ArithmeticException e) {
            e.getStackTrace();
            System.out.println(" ");
        } finally {
            System.out.println("finally");
        }
        System.out.println("here");
    }

    public static void main9(String[] args) {
        Student student = new Student(5);
        System.out.println(student.clone());
    }

    public static void main8(String[] args) throws CloneNotSupportedException {
        testClass testClass = new testClass();
        testClass.clone();
    }

    public static void main7(String[] args) {
        Student student = new Student(5);
        student.clone();
    }

    public static void main6(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abcd");
        for (int i = 0; i < 5; i++) {
            stringBuffer.append(i);
        }
        System.out.println(stringBuffer);
    }

    public static void main5(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(3);
        System.out.println(stringBuilder);
    }

    public static void main4(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("shi");
        StringBuilder stringBuilder1 = stringBuilder.append(45);
        StringBuilder stringBuilder2 = stringBuilder1.append(34);
        stringBuilder2.append(4);
        System.out.println(stringBuilder1);
        System.out.println(stringBuilder2);
    }

    public static void main3(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abcd");
        stringBuffer.append("efg");
        System.out.println(stringBuffer);
    }

    private static void testMethod() {
        System.out.println("testMethod");
    }

    public static void main1(String[] args) {
        testMethod();
        new Test2().testMethod();
        Test2.testMethod();
    }
}
