package com.AccioJob.MovieBookingApp.Controller;

import com.AccioJob.MovieBookingApp.EntryDTOs.TicketEntryDto;
import com.AccioJob.MovieBookingApp.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity getTicketsByUserId(@RequestParam int userId){
        return null;
    }

    @DeleteMapping("/cancelTicket")
    public ResponseEntity cancelTicket(@RequestParam int ticketId){

        return null;
    }
}
