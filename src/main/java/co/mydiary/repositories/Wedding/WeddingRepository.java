package co.mydiary.repositories.Wedding;

import co.mydiary.dtos.Wedding.ClothingDTO;
import co.mydiary.dtos.Wedding.EventDTO;
import co.mydiary.dtos.Wedding.VendorDTO;
import co.mydiary.repositories.Wedding.entities.ClothingEntity;
import co.mydiary.repositories.Wedding.entities.EventEntity;
import co.mydiary.repositories.Wedding.entities.EventsAllEntity;
import co.mydiary.repositories.Wedding.entities.VendorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class WeddingRepository {

    private NamedParameterJdbcTemplate template;

    @Autowired
    public WeddingRepository(NamedParameterJdbcTemplate t) {
        this.template = t;
    }

    public void addNewEvent(EventDTO eventDTO) {
        String query = "insert into weddingevents(eventtype, eventdate, guestcount, venue, budget) values(:et, :ed, :g, :v, :b)";
        Map<String, Object> param = new HashMap<>();
        param.put("et", eventDTO.getEventtype());
        param.put("ed", eventDTO.getEventdate());
        param.put("g", eventDTO.getGuestcount());
        param.put("v", eventDTO.getVenue());
        param.put("b", eventDTO.getBudget());

        template.update(query, param);
    }


    public void addNewClothing(ClothingDTO clothingDTO) {
        String query = "insert into weddingclothing(dresstype, color, norequired, boutique, budget, trialdates) values(:d, :c, :n, :bo, :b, :t)";
        Map<String, Object> param = new HashMap<>();
        param.put("d", clothingDTO.getDresstype());
        param.put("c", clothingDTO.getColor());
        param.put("n", clothingDTO.getNorequired());
        param.put("bo", clothingDTO.getBoutique());
        param.put("b", clothingDTO.getBudget());
        param.put("t", clothingDTO.getTrialDates());

        template.update(query, param);
    }


    public void addNewVendor(VendorDTO vendorDTO) {
        String query = "insert into weddingvendors(vendorname, vendortype, vbudget, eventhandled) values(:n, :t, :b, :e)";
        Map<String, Object> param = new HashMap<>();
        param.put("n", vendorDTO.getVendorname());
        param.put("t", vendorDTO.getVendortype());
        param.put("b", vendorDTO.getVbudget());
        param.put("e", vendorDTO.getEventhandled());

        template.update(query, param);
    }

    public List<EventEntity> getAllEvents() {
        String query = "select * from weddingevents";
        Map<String, Object> param = new HashMap<>();

        RowMapper<EventEntity> rowMapper = new BeanPropertyRowMapper<>(EventEntity.class);
        return template.query(query, param, rowMapper);
    }

    public List<ClothingEntity> getAllCothing() {
        String query = "select * from weddingclothing";
        Map<String, Object> param = new HashMap<>();

        RowMapper<ClothingEntity> rowMapper = new BeanPropertyRowMapper<>(ClothingEntity.class);
        return template.query(query, param, rowMapper);
    }

    public List<VendorEntity> getAllVendors() {
        String query = "select * from weddingvendors";
        Map<String, Object> param = new HashMap<>();

        RowMapper<VendorEntity> rowMapper = new BeanPropertyRowMapper<>(VendorEntity.class);
        return template.query(query, param, rowMapper);
    }

    public List<EventsAllEntity> getAllByEvent(String event) {
        String query = "select e.eventtype, e.eventdate, e.guestcount, e.venue, e.budget," +
                "v.vendorname, v.vendortype, v.vbudget from weddingevents e, weddingvendors v " +
                "where e.id = v.eventhandled and e.eventtype = :e";
        Map<String, Object> param = new HashMap<>();
        param.put("e", event);

        RowMapper<EventsAllEntity> rowMapper = new BeanPropertyRowMapper<>(EventsAllEntity.class);
        return template.query(query, param, rowMapper);

    }


    public void updateTrailDate(Date trialdate, Date newdate, String dress) {
        String query = "update weddingclothing set trialdates = :n where trialdates = :d and dresstype = :t";
        Map<String, Object> param = new HashMap<>();
        param.put("d", trialdate);
        param.put("n", newdate);
        param.put("t", dress);

        template.update(query, param);
    }


    public void updateEventBudget(String eventtype, int budget) {

        String query = "update weddingevents set budget = :b where eventtype = :e";
        Map<String, Object> param = new HashMap<>();
        param.put("b", budget);
        param.put("e", eventtype);

        template.update(query, param);
    }


    public void deleteVendor(String name) {
        String query = "delete from weddingvendors where vendorname = :n";
        Map<String, Object> param = new HashMap<>();
        param.put("n", name);

        template.update(query, param);
    }

    public void updateVendor(String vendorname, int event, String vendortype) {
        String query = "update weddingvendors set vendorname = :v where eventhandled = :e and vendortype = :vt";
        Map<String, Object> param = new HashMap<>();
        param.put("v", vendorname);
        param.put("e", event);
        param.put("vt", vendortype);

        template.update(query, param);

    }


}
