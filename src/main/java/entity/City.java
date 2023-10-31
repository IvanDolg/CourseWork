package entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private int id;
    private String name;
    private Country country;
}
