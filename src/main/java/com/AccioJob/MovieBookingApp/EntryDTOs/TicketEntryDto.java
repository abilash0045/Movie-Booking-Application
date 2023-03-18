package com.AccioJob.MovieBookingApp.EntryDTOs;

import lombok.Data;

import java.util.List;

@Data
public class TicketEntryDto {

    private List<String> requestedSeats;

    private int showId;

    private int userId;

}
