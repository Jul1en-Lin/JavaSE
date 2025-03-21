public class Test {
    public static void main(String[] args) {
        int i=0;
        int n=999999;
        for (i = 0; i < n; i++) {
            int count=0;
            int num=i;
            int sum=0;
            while (num!=0) {
                count++;
                num /= 10;
            }
            num=i;
            while(num!=0){
                sum+= (int) Math.pow(num%10,count);
                num/=10;
            }
            if(sum==i){
                System.out.println(sum);
            }
        }
    }
}
