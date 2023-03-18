package com.AccioJob.MovieBookingApp.Controller;

import com.AccioJob.MovieBookingApp.EntryDTOs.GetTheatersShowingDto;
import com.AccioJob.MovieBookingApp.EntryDTOs.TheaterEntryDto;
import com.AccioJob.MovieBookingApp.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity uniqueLocations(@RequestParam int theaterId){

        return null;
    }

    @GetMapping("/getTheatersForTime")
    public ResponseEntity getTheatersShowing(@RequestBody GetTheatersShowingDto getTheatersShowingDto){
        return null;
    }
}
