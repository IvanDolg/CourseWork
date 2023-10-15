package domain;

public class User {
    private int id;
    private String name;
    private String surname;
    private String userName;
    private String photo;
    private String email;
    private String password;
    private Country country;
    private String role;

    public static UserBuilder builder() {
        return new User().new UserBuilder();
    }

    public class UserBuilder{
        private UserBuilder() {
        }
        public UserBuilder setId(int id){
            User.this.id = id;
            return this;
        }

        public UserBuilder setName(String name){
            User.this.name = name;
            return this;
        }

        public UserBuilder setSurname(String surname) {
            User.this.surname = surname;
            return this;
        }

        public  UserBuilder setUserName(String userName){
            User.this.userName = userName;
            return this;
        }
        public UserBuilder setPhoto(String photo) {
            User.this.photo = photo;
            return this;
        }
        public UserBuilder setEmail(String email) {
            User.this.email = email;
            return this;
        }
        public UserBuilder setPassword(String password){
            User.this.password = password;
            return this;
        }
        public UserBuilder setCountry(Country country) {
            User.this.country = country;
            return this;
        }
        public  UserBuilder setRole(String role){
            User.this.role = role;
            return this;
        }
        public User build() {
            return User.this;
        }
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
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", userName='" + userName + '\'' +
                ", photo='" + photo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", country=" + country +
                ", role='" + role + '\'' +
                '}';
    }
}
