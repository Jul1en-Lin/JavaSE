public class Test {

    public static boolean isAdmin(String userId) {
        System.out.println(userId.toLowerCase() == "admin");
        return userId.toLowerCase().equals("admin");
       }
    public static void main(String[] args){
        System.out.println(isAdmin("Admin"));
    }

}
