package co.mydiary.repositories.Wedding.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventsAllEntity {
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

