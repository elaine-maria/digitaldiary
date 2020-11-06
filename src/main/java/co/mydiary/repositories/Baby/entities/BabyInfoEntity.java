package co.mydiary.repositories.Baby.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BabyInfoEntity {
    private int id;
    private String name;
    private Date eventday;
    private String description;
}
