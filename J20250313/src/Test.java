import com.test.demo1.Demo;

import java.util.*;
import java.math.*;//慎用
public class Test {
    public static void main(String[] args) {
        Demo demo=new Demo();
        System.out.println(demo);//动态绑定
        demo.setBrand(2);
        System.out.println(demo);
    }
}
