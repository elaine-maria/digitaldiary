package co.mydiary.repositories.Baby.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BabyAllEntity {

    private String name;
    private Date eventday;
    private String description;
    private double weight;
    private double height;

}
