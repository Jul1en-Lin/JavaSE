public class TestClass {

  private static void testMethod(){

    System.out.println("testMethod");

  }

  public static void main(String[] args) {
    TestClass testClass = null;
    testClass.testMethod();

    TestClass.testMethod();

    ((TestClass)null).testMethod();

  }

}