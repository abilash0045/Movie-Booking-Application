package com.AccioJob.MovieBookingApp.Service;

import com.AccioJob.MovieBookingApp.Entities.MovieEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.MovieEntryDto;
import com.AccioJob.MovieBookingApp.Repository.MovieRepository;
import com.AccioJob.MovieBookingApp.converters.MovieConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie (MovieEntryDto movieEntryDto) throws Exception{

        MovieEntity movieEntity = MovieConverters.movieDtoToEntity(movieEntryDto);

        movieRepository.save(movieEntity);

        return "Movie added successfully";
    }
}
