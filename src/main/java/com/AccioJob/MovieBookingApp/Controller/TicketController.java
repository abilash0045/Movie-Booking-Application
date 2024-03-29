package com.AccioJob.MovieBookingApp.Controller;

import com.AccioJob.MovieBookingApp.Domain.TicketEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.TicketEntryDto;
import com.AccioJob.MovieBookingApp.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getTicketsByUser")
    public ResponseEntity getTicketsByUserId(@RequestParam String userId){

        List<TicketEntity> response = ticketService.getTicketsForUser(userId);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @DeleteMapping("/cancelTicket")
    public ResponseEntity cancelTicket(@RequestParam String ticketId){

        String response = ticketService.cancelTicket(ticketId);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
}
