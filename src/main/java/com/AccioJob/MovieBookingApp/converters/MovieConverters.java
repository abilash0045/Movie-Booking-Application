package com.AccioJob.MovieBookingApp.converters;

import com.AccioJob.MovieBookingApp.Domain.MovieEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.MovieEntryDto;

public class MovieConverters {

    public static MovieEntity movieDtoToEntity(MovieEntryDto movieEntryDto){

        MovieEntity movieEntity = MovieEntity.builder()
                .movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .movieGenre(movieEntryDto.getMovieGenre())
                .rating(movieEntryDto.getRating())
                .language(movieEntryDto.getLanguage()).build();
        return movieEntity;
    }
}
