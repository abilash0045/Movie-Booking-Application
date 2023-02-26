package com.AccioJob.MovieBookingApp.EntryDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterEntryDto {

    private String name;

    private String location;

    private int classicSeatsCount;

    private int premiumSeatsCount;
}
