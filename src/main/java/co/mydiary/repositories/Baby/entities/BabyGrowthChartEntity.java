package co.mydiary.repositories.Baby.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BabyGrowthChartEntity {
    private int id;
    private int babyid;
    private String name;
    private double weight;
    private double height;
    private int year;
}
