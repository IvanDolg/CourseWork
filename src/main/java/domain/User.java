package domain;

public class User {
    private int id;
    private String name;
    private String userName;
    private String password;
    private String role;

    private static UserBuilder builder(){
        return new User().new UserBuilder();
    }

    public class UserBuilder{
        private UserBuilder(){}
        public UserBuilder setId(int id){
            User.this.id = id;
            return this;
        }

        public UserBuilder setName(String name){
            User.this.name = name;
            return this;
        }

        public  UserBuilder setUserName(String userName){
            User.this.userName = userName;
            return this;
        }
        public UserBuilder setPassword(String password){
            User.this.password = password;
            return this;
        }
        public  UserBuilder setRole(String role){
            User.this.role = role;
            return this;
        }
    }
    /*public User(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public User(int id, String name, String userName, String password) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public User( String name, String userName, String password, String role) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User(int id, String name, String userName, String password, String role) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }*/

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
