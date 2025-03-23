import java.util.Arrays;

public class Test {
    private static int ij(String s){
        String[] n = s.split(" ");
        for(String a : n){
            System.out.println(a);
        }
        String tmp = n[n.length-1];
        System.out.println(tmp.length());
        return 1;
    }

    public static void main(String[] args) {
        String s = "hei cool boys";
        ij(s);
    }
    public static int ji(String s){
        int index = s.lastIndexOf(" ");
        String z = s.substring(index+1);
        System.out.println(z.length());
        return 1;
    }

    public static void main1(String[] args) {
        String s = "hei cool boys";
        ji(s);
    }
    public int firstUniqChar(String s){
        int[] arrays = new int[127];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arrays[ch]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(arrays[ch] == 1) {
                return i;
            }
        }
        return -1;
     }
}
