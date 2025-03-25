public class testClass {

  private static void testMethod(){

    System.out.println("testMethod");

  }

  public static void main(String[] args) {

    ((testClass)null).testMethod();

  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}