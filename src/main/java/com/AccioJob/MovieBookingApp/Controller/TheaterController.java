package com.AccioJob.MovieBookingApp.Controller;

import com.AccioJob.MovieBookingApp.Domain.TheaterEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.GetTheatersShowingDto;
import com.AccioJob.MovieBookingApp.EntryDTOs.TheaterEntryDto;
import com.AccioJob.MovieBookingApp.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public String add(@RequestBody TheaterEntryDto theaterEntryDto){
        return theaterService.add(theaterEntryDto);
    }
    @GetMapping("/getUniqueLocations")
    public ResponseEntity uniqueLocations(@RequestParam String theaterName){

        int response = theaterService.getCountOfUniqueLocation(theaterName);

        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/getTheatersForTime")
    public ResponseEntity getTheatersShowing(@RequestBody GetTheatersShowingDto getTheatersShowingDto){

        List<TheaterEntity> response = theaterService.getTheatersForShowTime(getTheatersShowingDto);

        return new ResponseEntity(response,HttpStatus.FOUND);
    }
}
