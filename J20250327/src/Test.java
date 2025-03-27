import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class Basic {
    public void func () throws Exception {

    }
}

class Ap extends Basic{
    @Override
    public void func() throws Exception { //error {
        super.func();
}
}

/*class Basic {
    public void func () throws IOException {

    }
}

class Ap extends Basic{
    @Override
    public void func() throws Exception  {
        super.func();//error
    }
}*/
public class Test {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localDateTime);
        System.out.println(LocalDate.of(2024, 3, 12));
        System.out.println(localDateTime.getDayOfMonth());
        Locale locale = new Locale("English");
        System.out.println(DateTimeFormatter.ofPattern("六",locale));
    }

    public static void main2(String[] args){
        try{
            Login login = new Login("Jul1en",1234);
            login.fun1("Jul1en",12343);
        }catch (CodeErrorException e){
            e.printStackTrace();
            System.out.println("出现CodeErrorException");
        }finally{
            System.out.println("finally会被执行");
        }
        //System.out.println("here");
    }
    public static void main1(String[] args) throws UsernameErrorException,CodeErrorException{
        Login login = new Login("gaobo",1234);
        login.fun1("heihei",12);
    }
}
