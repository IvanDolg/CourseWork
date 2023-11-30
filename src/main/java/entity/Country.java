package entity;

import lombok.*;

import java.util.List;

@Getter @Setter @ToString
@NoArgsConstructor

public class Country {
    private int id;
    private String name;
    private List<City> cities;

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
