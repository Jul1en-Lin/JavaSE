public class HelloWorld {
    public static void main(String[] args) {
        int x=1;
        for(x=2;x<=100;x++){
            int i=2;
            boolean isPrime=true;
            for( ; i<=Math.sqrt(x);i++){
                if(x%i==0){
                   isPrime=false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(x+"是素数");
            }
        }
    }

    public static void main11(String[] args) {
        int x=1;
        for(x=2;x<=100;x++){
            int i=2;
            for( ; i<=Math.sqrt(x);i++){
                if(x%i==0){
                    //System.out.println(x+"不是素数");
                    break;
                }
            }
            if(i>Math.sqrt(x)){
                System.out.println(x+"是素数");
            }
        }
    }
}
