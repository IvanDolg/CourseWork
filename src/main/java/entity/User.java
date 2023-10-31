package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
}
