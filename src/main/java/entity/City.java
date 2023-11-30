package entity;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor

public class City {
    private int id;
    private String name;
    private Country country;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
