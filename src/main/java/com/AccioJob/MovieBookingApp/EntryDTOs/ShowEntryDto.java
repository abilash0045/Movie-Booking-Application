package com.AccioJob.MovieBookingApp.EntryDTOs;

import com.AccioJob.MovieBookingApp.Enums.ShowType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class ShowEntryDto {

    private LocalDate showDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime showTime;

    private ShowType showType;

    private String movieId;

    private String theaterId;

    private int classicSeats;

    private int premiumSeats;
}
