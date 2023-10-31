package entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private int id;
    private String name;
    private List<City> cities;
}
