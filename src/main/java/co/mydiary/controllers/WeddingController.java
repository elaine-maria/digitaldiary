package co.mydiary.controllers;

import co.mydiary.dtos.Wedding.ClothingDTO;
import co.mydiary.dtos.Wedding.EventDTO;
import co.mydiary.dtos.Wedding.VendorDTO;
import co.mydiary.exceptions.EventAccessException;
import co.mydiary.exceptions.NoBabyInfoForYearException;
import co.mydiary.services.WeddingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@Controller
@RequestMapping("/wedding")
public class WeddingController {

    private WeddingService service;

    @Autowired
    public WeddingController(WeddingService s) {
        this.service = s;
    }


    //Add a new wedding event
    @PostMapping(value = "/newevent", consumes = "application/json")
    public ResponseEntity addNewEvent(@RequestBody EventDTO eventDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addNewEvent(eventDTO));
    }

    //Add new wedding clothing details
    @PostMapping(value = "/newclothing", consumes = "application/json")
    public ResponseEntity addNewClothing(@RequestBody ClothingDTO clothingDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addNewClothing(clothingDTO));
    }

    //Add new vendor for wedding
    @PostMapping(value = "/new_vendor", consumes = "application/json")
    public ResponseEntity addNewVendor(@RequestBody VendorDTO vendorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addNewVendor(vendorDTO));
    }

    //Get all wedding events
    @GetMapping(value = "/events", produces = "application/json")
    public ResponseEntity getAllEvents() {
        return ResponseEntity.ok(service.getAllEvents());
    }

    //Get all Clothing details
    @GetMapping(value = "/clothing", produces = "application/json")
    public ResponseEntity getAllClothing() {
        return ResponseEntity.ok(service.getAllClothing());
    }

    //Get all Vendors
    @GetMapping(value = "/vendors", produces = "application/json")
    public ResponseEntity getAllVendors() {
        return ResponseEntity.ok(service.getAllVendors());
    }

    //Get all details of a particular event
    @GetMapping(value = ("/event/{event}"), produces = "application/json")
    public ResponseEntity getAllByEvent(@PathVariable String event) {
        if(service.getAllByEvent(event) == null) {
            log.warn("No entries for this event");
            throw new EventAccessException();
        }
        else
        return ResponseEntity.ok(service.getAllByEvent(event));
    }

    //Update the dresses trial date
    @PutMapping(value = "/trialdate/{trialdate}/{newdate}/{dress}", produces = "application/json")
    public ResponseEntity updateTrailDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date trialdate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date newdate, @PathVariable String dress) {
        log.info(String.valueOf(trialdate));
        service.updateTrailDate(trialdate, newdate, dress);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Update the budget for a particular event
    @PutMapping(value = "/eventbudget/{budget}/{eventtype}", produces = "application/json")
    public ResponseEntity updateEventBudget(@PathVariable String eventtype, @PathVariable int budget) {
        service.updateEventBudget(eventtype, budget);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Delete a particular vendor
    @DeleteMapping(value = "/vendorname/{name}")
    public ResponseEntity deleteVendor(@PathVariable String name) {
        service.deleteVendor(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Update the vendor for a particular event
    @PutMapping(value = "/eventhandled/{vendorname}/{event}/{vendortype}")
    public ResponseEntity updateVendor(@PathVariable String vendorname, @PathVariable int event, @PathVariable String vendortype) {
        service.updateVendor(vendorname, event, vendortype);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
