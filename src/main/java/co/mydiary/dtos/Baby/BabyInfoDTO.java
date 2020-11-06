package co.mydiary.dtos.Baby;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BabyInfoDTO {
    private int id;
    private String name;
    private Date eventday;
    private String description;

}
