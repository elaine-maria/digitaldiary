package co.mydiary.dtos.Baby;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BabyGrowthChartDTO {

    private int id;
    private int babyid;
    private String name;
    private double weight;
    private double height;
    private int year;
}
