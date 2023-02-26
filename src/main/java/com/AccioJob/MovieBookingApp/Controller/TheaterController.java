package com.AccioJob.MovieBookingApp.Controller;

import com.AccioJob.MovieBookingApp.EntryDTOs.TheaterEntryDto;
import com.AccioJob.MovieBookingApp.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public String add(@RequestBody TheaterEntryDto theaterEntryDto){
        return "";
    }
}
