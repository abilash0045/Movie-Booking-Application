package com.AccioJob.MovieBookingApp.Service;

import com.AccioJob.MovieBookingApp.Entities.MovieEntity;
import com.AccioJob.MovieBookingApp.Entities.ShowEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.MovieEntryDto;
import com.AccioJob.MovieBookingApp.Repository.MovieRepository;
import com.AccioJob.MovieBookingApp.Repository.ShowRepository;
import com.AccioJob.MovieBookingApp.converters.MovieConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;

    public String addMovie (MovieEntryDto movieEntryDto) throws Exception{

        MovieEntity movieEntity = MovieConverters.movieDtoToEntity(movieEntryDto);

        movieRepository.save(movieEntity);

        return "Movie added successfully";
    }
    public String getMovieWithMaxShows(){

        int movieEntityId = movieRepository.getMaxShowMovie();

        MovieEntity movieEntity = movieRepository.findById(movieEntityId).get();

        return movieEntity.getMovieName();
    }
}
