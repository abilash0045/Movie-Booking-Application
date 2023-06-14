package com.AccioJob.MovieBookingApp.Service;

import com.AccioJob.MovieBookingApp.Domain.MovieEntity;
import com.AccioJob.MovieBookingApp.Domain.ShowEntity;
import com.AccioJob.MovieBookingApp.Domain.ShowSeatEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.MovieEntryDto;
import com.AccioJob.MovieBookingApp.EntryDTOs.RatingDto;
import com.AccioJob.MovieBookingApp.Repository.MovieRepository;
import com.AccioJob.MovieBookingApp.Repository.ShowRepository;
import com.AccioJob.MovieBookingApp.converters.MovieConverters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;

    public String addMovie (MovieEntryDto movieEntryDto) throws Exception{

        logger.info("inside add method");

        MovieEntity movieEntity = MovieConverters.movieDtoToEntity(movieEntryDto);
        logger.info("converted to entity" + movieEntity.toString());

        movieRepository.save(movieEntity);

        return "Movie added successfully";
    }
    public String getMovieWithMaxShows(){

//        String movieEntityId = movieRepository.getMaxShowMovie();

//        MovieEntity movieEntity = movieRepository.findById(movieEntityId).get();
//
//        return movieEntity.getMovieName();
        return null;
    }

    public int getRevenue(String movieId){


        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        List<ShowEntity> shows = movieEntity.getShowEntities();

        int totalRevenue = 0;
        for (ShowEntity showEntity : shows){

            List<ShowSeatEntity> showSeatEntities = showEntity.getShowSeatEntities();

            for (ShowSeatEntity showSeatEntity : showSeatEntities){

                if (showSeatEntity.isBooked()){
                    totalRevenue += showSeatEntity.getPrice();
                }
            }
        }
        return totalRevenue;
    }

    public String addRating(RatingDto ratingDto){

        MovieEntity movieEntity = movieRepository.findById(ratingDto.getMovieId()).get();
        movieEntity.setRating(ratingDto.getRating());
        movieRepository.save(movieEntity);

        return "rating added successfully";
    }

    public MovieEntity findByMovieName(String movieName){
        return movieRepository.findByMovieNameIgnoreCase(movieName);
    }
}
