package entity;

import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Exercises {
    private int id;
    private String name;
    private String description;
    private String rightCode;
    private int scores;
}
