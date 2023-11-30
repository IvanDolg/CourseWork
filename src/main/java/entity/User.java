package entity;

import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Builder

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
}
