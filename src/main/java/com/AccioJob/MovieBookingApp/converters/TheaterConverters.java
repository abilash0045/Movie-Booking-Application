package com.AccioJob.MovieBookingApp.converters;

import com.AccioJob.MovieBookingApp.Domain.TheaterEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.TheaterEntryDto;

public class TheaterConverters {

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        TheaterEntity theaterEntity = TheaterEntity.builder()
                .name(theaterEntryDto.getName())
                .location(theaterEntryDto.getLocation())
                .build();
        return theaterEntity;
    }
}
