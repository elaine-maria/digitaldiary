package co.mydiary.services;

import co.mydiary.dtos.Baby.BabyAllDTO;
import co.mydiary.dtos.Baby.BabyInfoDTO;
import co.mydiary.dtos.Baby.BabyGrowthChartDTO;
import co.mydiary.repositories.Baby.BabyRepository;
import co.mydiary.repositories.Baby.entities.BabyAllEntity;
import co.mydiary.repositories.Baby.entities.BabyInfoEntity;
import co.mydiary.repositories.Baby.entities.BabyGrowthChartEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BabyService {

    private BabyRepository repository;
    private MapperFacade mapperFacade;

//    @Autowired
//    public BabyService(BabyRepository r) {
//        this.repository = r;
//    }

    public List<BabyInfoDTO> getAllBabyInfo() {
        List<BabyInfoEntity> entities = repository.getAlBabyInfo();
        return mapperFacade.mapAsList(entities, BabyInfoDTO.class);
//        List<BabyDTO> dto = new ArrayList<>();
//        for(BabyEntity e: entities) {
//            BabyDTO baby = new BabyDTO(e.getId(), e.getName(), e.getEventday(), e.getDescription());
//            dto.add(baby);
//        }
//        return dto;
    }

    public List<BabyGrowthChartDTO> getAllBabyGrowthInfo() {
        List<BabyGrowthChartEntity> entities = repository.getAllBabyGrowthInfo();
        return mapperFacade.mapAsList(entities, BabyGrowthChartDTO.class);
//        List<BabyGrowthChartDTO> dto = new ArrayList<>();
//        for(BabyGrowthChartEntity e: entities) {
//            BabyGrowthChartDTO baby = new BabyGrowthChartDTO(e.getId(), e.getBabyid(),e.getName(), e.getHeight(), e.getWeight());
//            dto.add(baby);
//        }
//        return dto;
    }

    public List<BabyAllDTO> getAllByName(String name) {
        List<BabyAllEntity> entities = repository.getAlByName(name);
        log.warn("Getting all by name");
        List<BabyAllDTO> dto = new ArrayList<>();
        for(BabyAllEntity e: entities) {
            BabyAllDTO baby = new BabyAllDTO(e.getName(), e.getEventday(), e.getDescription(), e.getWeight(), e.getHeight());
            dto.add(baby);
        }
        return dto;
    }

    public BabyInfoDTO addNewEntry(BabyInfoDTO babyInfoDTO) {
//        repository.addNewEntry(babyDTO);
//        return babyDTO;

        BabyInfoEntity e = new BabyInfoEntity(1, babyInfoDTO.getName(), babyInfoDTO.getEventday(), babyInfoDTO.getDescription());
        log.warn("babyinfo service call");
        repository.addNewEntry(e);
        return babyInfoDTO;
    }

    public BabyGrowthChartDTO addNewGrowthEntry(BabyGrowthChartDTO babyGrowthChartDTO) {
        log.warn("Service called");
        repository.addNewGrowthEntry(babyGrowthChartDTO);
        return babyGrowthChartDTO;

    }

    public List<BabyInfoDTO> getAllByYear(int year) {
        List<BabyInfoEntity> entities = repository.getAllByYear(year);
        return mapperFacade.mapAsList(entities, BabyInfoDTO.class);
//        List<BabyDTO> dto = new ArrayList<>();
//        for(BabyEntity e: entities) {
//            BabyDTO baby = new BabyDTO(e.getId(), e.getName(), e.getEventday(), e.getDescription());
//            dto.add(baby);
//        }
//        return dto;
    }


}
