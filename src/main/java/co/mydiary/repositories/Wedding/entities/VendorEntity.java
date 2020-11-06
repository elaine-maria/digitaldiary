package co.mydiary.repositories.Wedding.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorEntity {
    private int id;
    private String vendorname;
    private String vendortype;
    private int vbudget;
    private int eventhandled;
}


