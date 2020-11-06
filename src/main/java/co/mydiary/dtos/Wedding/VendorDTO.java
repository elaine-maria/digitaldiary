package co.mydiary.dtos.Wedding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {
    private int id;
    private String vendorname;
    private String vendortype;
    private int vbudget;
    private int eventhandled;
}

