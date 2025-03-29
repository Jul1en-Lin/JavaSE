package demo1;
//懒汉式
public class Principal {
    private static Principal instance;
    private String name;
    private int ID;
    private Principal(){
        name = "老表";
        ID = 1;
    }
    public static Principal getInstance() {
        if (instance == null) {
            instance = new Principal();
        }
        return instance;
    }
}
