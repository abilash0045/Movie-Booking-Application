package com.AccioJob.MovieBookingApp.Service;

import com.AccioJob.MovieBookingApp.Entities.*;
import com.AccioJob.MovieBookingApp.EntryDTOs.TicketEntryDto;
import com.AccioJob.MovieBookingApp.Repository.ShowRepository;
import com.AccioJob.MovieBookingApp.Repository.TicketRepository;
import com.AccioJob.MovieBookingApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public String bookTickets(TicketEntryDto ticketEntryDto) throws Exception{

        TicketEntity ticketEntity = new TicketEntity();

        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();
        ticketEntity.setShow(showEntity);
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());

        if (checkAvailability(ticketEntryDto) == false){
            throw new Exception("Seat is Already booked");
        }

        //book seats
        List<ShowSeatEntity> showSeatEntityList = showEntity.getShowSeatEntities();
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

        int totalAmount = 0;

        for (ShowSeatEntity showSeatEntity : showSeatEntityList){
            if (requestedSeats.contains(showSeatEntity.getSeatNo())){
                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedAt(new Date());
                totalAmount += showSeatEntity.getPrice();
            }
        }
        ticketEntity.setTotalAmount(totalAmount);
        String bookedSeats = getBookedSeatsAsString(requestedSeats);
        ticketEntity.setBookedSeats(bookedSeats);

        //------------------done booking--------------------------

        TheaterEntity theaterEntity = showEntity.getTheaterEntity();
        MovieEntity movieEntity = showEntity.getMovieEntity();

        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId()).get();
        ticketEntity.setUserEntity(userEntity);

        ticketEntity.setTheaterName(theaterEntity.getName());
        ticketEntity.setMovieName(movieEntity.getMovieName());

        ticketEntity = ticketRepository.save(ticketEntity);

        showEntity.getTicketEntities().add(ticketEntity);
        userEntity.getBookedTickets().add(ticketEntity);

        userRepository.save(userEntity);
        showRepository.save(showEntity);

        // Email integration
        String body = "Hi this is to confirm your booking for seat No "+bookedSeats +"for the movie : " + ticketEntity.getMovieName();


        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("moviebookingapp.com@gmail.com");
        mimeMessageHelper.setTo(userEntity.getEmail());
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject("Confirming your booked Ticket");

        javaMailSender.send(mimeMessage);

        return "Ticket Booked Successfully";
    }

    private String getBookedSeatsAsString(List<String> requestedSeats){

        String bookedSeats = "";

        for (String seats : requestedSeats){
            bookedSeats += seats + " ";
        }
        return bookedSeats;
    }
    private boolean checkAvailability(TicketEntryDto ticketEntryDto){

        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();

        List<ShowSeatEntity> showSeatEntityList = showEntity.getShowSeatEntities();

        List<String> requestedSeats  = ticketEntryDto.getRequestedSeats();

        for (ShowSeatEntity showSeatEntity : showSeatEntityList){
            if (requestedSeats.contains(showSeatEntity.getSeatNo())){
                if (showSeatEntity.isBooked()==true){
                    return false;
                }
            }
        }
        return true;
    }
}
