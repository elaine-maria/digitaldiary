package co.mydiary.dtos.Wedding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventsAllDTO {
    private int id;
    private String eventtype;
    private Date eventdate;
    private int guestcount;
    private String venue;
    private int budget;
    private String vendorname;
    private String vendortype;
    private int vbudget;

}
