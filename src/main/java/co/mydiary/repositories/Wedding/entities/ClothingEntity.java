package co.mydiary.repositories.Wedding.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClothingEntity {
    private int id;
    private String dresstype;
    private String color;
    private int norequired;
    private String boutique;
    private int budget;
    private Date trialDates;
}


