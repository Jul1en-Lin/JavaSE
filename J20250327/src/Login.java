public class Login {
    public String username;
    public int code;

    public Login(String username, int code) {
        this.username = username;
        this.code = code;
    }
    public void fun1 (String username,int code) throws UsernameErrorException,CodeErrorException{
        if (! this.username.equals(username)) {
            throw new UsernameErrorException();
        }
        if (this.code != code){
            throw new CodeErrorException();
        }
    }

}
