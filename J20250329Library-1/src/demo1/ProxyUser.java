package demo1;

public class ProxyUser {
    private User realUser;

    public ProxyUser(User user){
        this.realUser = user;
    }

    public void display(){
        this.realUser.display();
    }

    public void borrrowBook(){
        if (this.realUser instanceof NormalUser){
            System.out.println("有权限");
        } else if (this.realUser instanceof AdminUser) {
            System.out.println("无权限");
        }
    }
    public void addBook(){
        if (this.realUser instanceof AdminUser){
            System.out.println("有权限");
        } else if (this.realUser instanceof NormalUser) {
            System.out.println("无权限");
        }
    }
}
