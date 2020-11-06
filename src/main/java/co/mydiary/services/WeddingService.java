package co.mydiary.services;

import co.mydiary.dtos.Wedding.ClothingDTO;
import co.mydiary.dtos.Wedding.EventDTO;
import co.mydiary.dtos.Wedding.EventsAllDTO;
import co.mydiary.dtos.Wedding.VendorDTO;
import co.mydiary.exceptions.BudgetExceededException;
import co.mydiary.exceptions.EventAccessException;
import co.mydiary.repositories.Wedding.WeddingRepository;
import co.mydiary.repositories.Wedding.entities.ClothingEntity;
import co.mydiary.repositories.Wedding.entities.EventEntity;
import co.mydiary.repositories.Wedding.entities.EventsAllEntity;
import co.mydiary.repositories.Wedding.entities.VendorEntity;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class WeddingService {

    private WeddingRepository repository;

    private MapperFacade mapperFacade;

    @Autowired
    public WeddingService(WeddingRepository r, MapperFacade m) {
        this.repository = r;
        this.mapperFacade = m;
    }

    public EventDTO addNewEvent(EventDTO eventDTO) {
        repository.addNewEvent(eventDTO);
        return eventDTO;
    }


    public ClothingDTO addNewClothing(ClothingDTO clothingDTO) {
        repository.addNewClothing(clothingDTO);
        return clothingDTO;
    }

    public VendorDTO addNewVendor(VendorDTO vendorDTO) {
        repository.addNewVendor(vendorDTO);
        return vendorDTO;
    }

    public List<EventDTO> getAllEvents() {
        List<EventEntity> entities = repository.getAllEvents();
        return mapperFacade.mapAsList(entities, EventDTO.class);
    }


    public List<ClothingDTO> getAllClothing() {
        List<ClothingEntity> entities = repository.getAllCothing();
        return mapperFacade.mapAsList(entities, ClothingDTO.class);
    }


    public List<VendorDTO> getAllVendors() {
        List<VendorEntity> entities = repository.getAllVendors();
        return mapperFacade.mapAsList(entities, VendorDTO.class);
    }

    public List<EventsAllDTO> getAllByEvent(String event) {
        List<EventsAllEntity> entities = repository.getAllByEvent(event);
            return mapperFacade.mapAsList(entities, EventsAllDTO.class);
    }

    public void updateTrailDate(Date trialdate, Date newdate, String dress) {
        repository.updateTrailDate(trialdate, newdate, dress);
    }

    public void updateEventBudget(String eventtype, int budget) {
        if (budget > EventDTO.MAX_Budget) {
            log.warn("Budget exceeded");
            throw new BudgetExceededException();
        }
        repository.updateEventBudget(eventtype, budget);
    }


    public void deleteVendor(String name) {
        repository.deleteVendor(name);
    }


    public void updateVendor(String vendorname, int event, String vendortype) {
        repository.updateVendor(vendorname, event, vendortype);
    }


}
