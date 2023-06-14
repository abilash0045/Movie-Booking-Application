package com.AccioJob.MovieBookingApp.EntryDTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieTheaterEntryDto {

    private String movieId;

    private String theaterId;
}
