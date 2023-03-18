package com.AccioJob.MovieBookingApp.Controller;

import com.AccioJob.MovieBookingApp.EntryDTOs.MovieEntryDto;
import com.AccioJob.MovieBookingApp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody MovieEntryDto movieEntryDto){
        try {
            String response = movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            String response = "Unable to add movie";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST); 
        }
    }

    @GetMapping("/getMovieWithMaxShows")
    public ResponseEntity getMovieWithMaximumShows(){

        String response = movieService.getMovieWithMaxShows();
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @GetMapping("/getRevenueForMovie")
    public ResponseEntity getRevenueForMovie(@RequestParam int movieId){

        return null;
    }

    @PutMapping("/rateMovie")
    public ResponseEntity rateMovie(){

        return null;
    }
}
