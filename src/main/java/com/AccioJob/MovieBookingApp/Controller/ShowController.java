package com.AccioJob.MovieBookingApp.Controller;


import com.AccioJob.MovieBookingApp.EntryDTOs.MovieTheaterEntryDto;
import com.AccioJob.MovieBookingApp.EntryDTOs.ShowEntryDto;
import com.AccioJob.MovieBookingApp.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){

        String response = showService.addShow(showEntryDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getShows")
    public ResponseEntity<String> getShowTimings(@RequestBody MovieTheaterEntryDto movieTheaterEntryDto){

        String response = showService.getShowTime(movieTheaterEntryDto);

        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
