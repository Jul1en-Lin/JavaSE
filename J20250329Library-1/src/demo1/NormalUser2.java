package demo1;
//懒汉式
public class NormalUser2{
    private static NormalUser2 instance;

    public NormalUser2(String name, int userID) {

    }

    public NormalUser2 getInstance(){
        if (instance == null){
            instance = new NormalUser2("李四",2);
        }
        return instance;
    }
}
