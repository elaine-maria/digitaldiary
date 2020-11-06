package co.mydiary.repositories.Baby;

import co.mydiary.dtos.Baby.BabyGrowthChartDTO;
import co.mydiary.repositories.Baby.entities.BabyAllEntity;
import co.mydiary.repositories.Baby.entities.BabyInfoEntity;
import co.mydiary.repositories.Baby.entities.BabyGrowthChartEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class BabyRepository {

    private NamedParameterJdbcTemplate template;

    @Autowired
    public BabyRepository(NamedParameterJdbcTemplate t){
        this.template = t;
    }

    public List<BabyInfoEntity> getAlBabyInfo() {
        String query = "select * from babyinfo";
        Map<String, Object> param = new HashMap<>();

        RowMapper<BabyInfoEntity> rowMapper = new BeanPropertyRowMapper<>(BabyInfoEntity.class);
        return template.query(query, param, rowMapper);
    }

    public List<BabyGrowthChartEntity> getAllBabyGrowthInfo() {
        String query = "select * from babygrowthchart";
        Map<String, Object> param = new HashMap<>();

        RowMapper<BabyGrowthChartEntity> rowMapper = new BeanPropertyRowMapper<>(BabyGrowthChartEntity.class);
        return template.query(query, param, rowMapper);
    }

    public List<BabyAllEntity> getAlByName(String name) {
        String query = "select b.name, b.eventday, b.description, g.weight, g.height " +
                "from babyinfo b, babygrowthchart g where b.id = g.babyid and b.name = :var";
        Map<String, Object> param = new HashMap<>();
        param.put("var", name);
        log.warn("Getting all by name");
        RowMapper<BabyAllEntity> rowMapper = new BeanPropertyRowMapper<>(BabyAllEntity.class);
        return template.query(query, param, rowMapper);
    }

    public List<BabyInfoEntity> getAllByYear(int year) {
        String query = "select * from babyinfo where year(eventday) = :y";
        Map<String, Object> param = new HashMap<>();
        param.put("y", year);
        RowMapper<BabyInfoEntity> rowMapper = new BeanPropertyRowMapper<>(BabyInfoEntity.class);
        return template.query(query, param, rowMapper);
    }

    public void addNewEntry(BabyInfoEntity babyInfoEntity) {
        String query = "insert into babyinfo(name, eventday, description) values(:n, :e, :d)";
        Map<String, Object> param = new HashMap<>();
        param.put("n", babyInfoEntity.getName());
        param.put("e", babyInfoEntity.getEventday());
        param.put("d", babyInfoEntity.getDescription());
        log.warn("inserting new entry in babyinfo");
        template.update(query, param);
    }

    public void addNewGrowthEntry(BabyGrowthChartDTO babyGrowthChartDTO) {
        String query = "insert into babygrowthchart(babyid, name, weight, height, year) values(:b, :n, :w, :h, :y)";
        Map<String, Object> param = new HashMap<>();
        param.put("b", babyGrowthChartDTO.getBabyid());
        param.put("n", babyGrowthChartDTO.getName());
        param.put("w", babyGrowthChartDTO.getWeight());
        param.put("h", babyGrowthChartDTO.getHeight());
        param.put("y", babyGrowthChartDTO.getYear());
        log.warn("inserting new entry in babygrowthchart");
        template.update(query, param);
    }


}
