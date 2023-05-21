package com.AccioJob.MovieBookingApp.Controller;

import com.AccioJob.MovieBookingApp.EntryDTOs.MovieEntryDto;
import com.AccioJob.MovieBookingApp.EntryDTOs.RatingDto;
import com.AccioJob.MovieBookingApp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    MovieService movieService = new MovieService();

//    @PostMapping("/add")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
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

        int response = movieService.getRevenue(movieId);
        return new ResponseEntity(response,HttpStatus.ACCEPTED);
    }

    @PutMapping("/rateMovie")
    public ResponseEntity rateMovie(@RequestBody RatingDto ratingDto){

        String response = movieService.addRating(ratingDto);

        return new ResponseEntity(response,HttpStatus.ACCEPTED);
    }
}
