package demo1;

public class NormalUser extends User{
    public NormalUser(String name, int userID) {
        super(name, userID, "管理员");
    }

    @Override
    public void display() {

    }
    public void borrowBook(){

    }
}
