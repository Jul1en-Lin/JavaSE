package demo1;

import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            int index = str.lastIndexOf(" ");
            String tmp = str.substring(index+1);
            System.out.println(tmp.length());
        }
    }
    public static void main17(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            String[] tmp = str.split(" ");
            String ret = tmp[tmp.length-1];
            System.out.println(ret.length());
        }
    }
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length();i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length();i++) {
            char tmp = s.charAt(i);
            if (arr[s.charAt(i)-'a'] == 1);
            return i;
        }
        return -1;

    }
    public static void main16(String[] args) {
        char[] chars = {'a','b','c','d','d','e'};
        String s1 = new String(chars);
        //s1.intern();
        String s2 = "abcdde";
        System.out.println(Integer.toHexString(System.identityHashCode(s1)));
        System.out.println(Integer.toHexString(System.identityHashCode(s2)));
        //地址并不一样
        System.out.println(s1.equals(s2));//比较引用的对象是同一个
    }
    public static void main15(String[] args) {
        char[] chars = {'a','b','c','d','d','e'};
        String s1 = new String(chars);
        s1.intern();
        String s2 = "abcdde";
        System.out.println(s1==s2);
    }
    public static void main14(String[] args) {
        String s1 = " abc defg ";
        String s = s1.trim();
        System.out.println("["+s+"]");
    }
    public static void main13(String[] args) {
        String s1 = "abcdefg";
        String s = s1.replace("abc","ABC");
        System.out.println(s);
        String s2 = "abcdabcdabcd";
        String s3 = s2.replace("abc","ABC");
        String s4 = s2.replace("a","k");
        System.out.println(s3);
        System.out.println(s4);
    }
    public static void main12(String[] args) {
        String s = String.format("%d年\\%d月\\%d日",2025,03,23);
        //第一个\是转义字符，第二个\才是真正显示的
        System.out.println(s);
    }
    public static void main11(String[] args) {
        String s1 = "abcdefg";
        char[]s = s1.toCharArray();
        System.out.println(s[1]+" + "+s[0]);
    }
    public static void main10(String[] args) {
        //字符串转数字
        int data1 = Integer.parseInt("1234");
        double data2 = Double.parseDouble("12.34");
        int data3 = Integer.compare(1,3);
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
    }
    public static void main9(String[] args) {
        //数字转换字符串
        String s1 = String.valueOf(1234);
        String s2 = String.valueOf(12.34);
        String s3 = String.valueOf(true);
        String s4 = String.valueOf(new Student(18, "Hanmeimei"));
        //调用student的toString，如果没有就调用Object的
        String s5 = String.valueOf(new Class(18));
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }
    public static void main8(String[] args) {
        String s1 = "abcdefg";
        int ret = s1.indexOf("c");
        System.out.println(ret);
        int tmp = s1.lastIndexOf("bcd",10);
        System.out.println(tmp);
    }
    public static void main7(String[] args) {
        String s1 = "a FJ Ic d";
        String[] s2 = s1.split(" ");
        String s3 = "a &FJ =Ic d";
        String[] s4 = s1.split(" |&|=");
        for(String s : s2) {
            System.out.println(s);
        }
        System.out.println("=====");
        for(String i : s4) {
            System.out.println(i);
        }
    }
    public static void main6(String[] args) {
        String s1 = "aFJIcd";
        String s = s1.repeat(3);
        System.out.println(s);
        System.out.println("=======");
        String s3 = s1.substring(3,5);
        System.out.println(s3);
        //左闭右开[3，5)
    }
    public static void main5(String[] args) {
        String s1 = "aFJIcd";
        String s2 = "abSF#@$cdter";
        String s3 = s1.toUpperCase();
        String s4 = s2.toUpperCase();
        System.out.println(s3);
        System.out.println(s4);
        String s5 = s2.toLowerCase(Locale.ROOT);
        System.out.println(Integer.toHexString(System.identityHashCode(s5)));
        String s6 = s2.toLowerCase();
        System.out.println(Integer.toHexString(System.identityHashCode(s5)));
        System.out.println(s5);
    }
    public static void main4(String[] args) {
        String s1 = "abcd";
        String s2 = "abcdter";
        String s3 = "abcd324";
        String s4 = "abcd1";
        String s5 = "abcd34";
        System.out.println(s1.compareTo(s3));
        System.out.println(s1.compareTo(s4));
        System.out.println(s1.compareTo(s5));
    }
    public static void main3(String[] args) {
        String s1 = "abcd";
        String s2 = "abcd";
        System.out.println("s1地址：0x" + Integer.toHexString(System.identityHashCode(s1)));
        System.out.println("s2地址：0x" + Integer.toHexString(System.identityHashCode(s2)));
        System.out.println(s1.equals(s2));
    }
    public static void main2(String[] args) {
        String s = "hello bit";
        String s1 = new String("hello world");
        System.out.println(s);
        System.out.println(s1);
    }
    public static void main1(String[] args) {
        char[] chars = {'h','e','l','l','o','b','i','t'};
        String s = new String(chars);
        System.out.println(s);
    }
}
