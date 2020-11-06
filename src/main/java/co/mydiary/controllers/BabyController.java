package co.mydiary.controllers;

import co.mydiary.dtos.Baby.BabyInfoDTO;
import co.mydiary.dtos.Baby.BabyGrowthChartDTO;
import co.mydiary.exceptions.NoBabyInfoForYearException;
import co.mydiary.services.BabyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/baby")
public class BabyController {

    private BabyService service;

    @Autowired
    public BabyController(BabyService s) {
        this.service = s;
    }


    //Get All Information on Baby
    @GetMapping(produces = "application/json")
    public ResponseEntity getAllBabyInfo() {
        return ResponseEntity.ok(service.getAllBabyInfo());
    }

    //Get All Information on Baby  growth
    @GetMapping(value = "/babygrowth", produces = "application/json")
    public ResponseEntity getAllBabyGrowthInfo() {
        return ResponseEntity.ok(service.getAllBabyGrowthInfo());
    }

    //Get All Information based on particular name
    @GetMapping(value = ("/name/{name}"), produces = "application/json")
    public ResponseEntity getAllByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getAllByName(name));
    }

    //Get All Information for a particular year
    @GetMapping(value = "/year/{year}", produces = "application/json")
    public ResponseEntity getAllByYear(@PathVariable int year) {
        if(ResponseEntity.ok(service.getAllByYear(year)) == null) {
            log.warn("This year has no entries");
            throw new NoBabyInfoForYearException();
        }
        else
            return ResponseEntity.ok(service.getAllByYear(year));
    }

    //Add a new entry to BabyGrowthchart
    @PostMapping(value = "/addgrowth", consumes = "application/json")
    public ResponseEntity addNewGrowthEntry(@RequestBody BabyGrowthChartDTO babyGrowthChartDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addNewGrowthEntry(babyGrowthChartDTO));
    }

    //Add new entry to Baby Information
    @PostMapping(value = "/addbaby", consumes = "application/json")
    public ResponseEntity addNewEntry(@RequestBody BabyInfoDTO babyInfoDTO) {
        BabyInfoDTO newEntry = service.addNewEntry(babyInfoDTO);
        ResponseEntity response = ResponseEntity.status(HttpStatus.CREATED).body(newEntry);
        return response;
    }

}
