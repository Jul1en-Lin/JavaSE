import java.util.Scanner;

public class Test {
    //字符串加法
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String a = in.next();
            String b = in.next();
            String ret = add(a, b);
            System.out.println(ret);
        }
    }
    public static String add(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        StringBuilder stringBuilderA = new StringBuilder(a);
        StringBuilder stringBuilderB = new StringBuilder(b);
        int max = Math.max(lengthA,lengthB);
        //逆置
        StringBuilder reverseA = stringBuilderA.reverse();
        StringBuilder reverseB = stringBuilderB.reverse();
        //进位标识
        boolean flg = false;
        StringBuilder stringTemp = new StringBuilder();
        for (int i = 0; i < max; i++) {
            char cha = i > lengthA ? '0' : reverseA.charAt(i);
            char chb = i > lengthB ? '0' : reverseB.charAt(i);
            if (cha == '1' & chb == '1'){
                if (flg){
                    stringTemp.append('1');
                }else {
                    stringTemp.append('0');
                }
                flg = true;
            } else if (cha == '0' & chb == '0') {
                if (flg) {
                    stringTemp.append('1');
                }else{
                    stringTemp.append('0');
                }
                flg = false;
            } else {
                //由于‘0’ 和 ‘1’ 的计算后是否有进位的情况比较复杂 故先计算后再进行进位的计算
                if (flg) {
                    stringTemp.append('0');
                }else{
                    stringTemp.append('1');
                }
            }
        }
        if (flg) {
            stringTemp.append('1');
        }
        return stringTemp.reverse().toString();
    }
    //删除公共字符
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
         {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            for (int i = 0; i < str1.length(); i++) {
                char ch1 = str1.charAt(i);
                if (! str2.contains(ch1+"")){
                    stringBuilder.append(ch1);
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
    //大小写转换
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();//A
            char ch = str.charAt(0);
            if (Character.isUpperCase(ch)) {
                char ret = (char) (ch + 32);
                System.out.println(ret);
            }
        }
    }
}
