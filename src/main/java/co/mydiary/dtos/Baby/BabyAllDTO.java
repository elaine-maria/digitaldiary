package co.mydiary.dtos.Baby;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BabyAllDTO {

    private String name;
    private Date eventday;
    private String description;
    private double weight;
    private double height;
}
