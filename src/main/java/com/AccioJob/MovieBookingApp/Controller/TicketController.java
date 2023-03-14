package com.AccioJob.MovieBookingApp.Controller;

import com.AccioJob.MovieBookingApp.EntryDTOs.TicketEntryDto;
import com.AccioJob.MovieBookingApp.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity<String> bookTicket(@RequestBody TicketEntryDto ticketEntryDto){

        try{
            String response = ticketService.bookTickets(ticketEntryDto);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(""+e,HttpStatus.BAD_REQUEST);
        }
    }
}
