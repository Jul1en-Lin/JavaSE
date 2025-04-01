package user;

public abstract class User {
    public String name;
    public int userID;
    public String role;

    public User(String name, int userID, String role) {
        this.name = name;
        this.userID = userID;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public abstract int display();

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", userID=" + userID +
                ", role='" + role + '\'' +
                '}';
    }
}
