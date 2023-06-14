package com.AccioJob.MovieBookingApp.EntryDTOs;

import com.AccioJob.MovieBookingApp.Enums.Language;
import com.AccioJob.MovieBookingApp.Enums.MovieGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntryDto {

    private String movieName;

    private double rating;

    private int duration;

    private MovieGenre movieGenre;

    private Language language;
}
