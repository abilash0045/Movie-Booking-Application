package com.AccioJob.MovieBookingApp.Service;

import com.AccioJob.MovieBookingApp.Entities.*;
import com.AccioJob.MovieBookingApp.EntryDTOs.MovieTheaterEntryDto;
import com.AccioJob.MovieBookingApp.EntryDTOs.ShowEntryDto;
import com.AccioJob.MovieBookingApp.Enums.SeatType;
import com.AccioJob.MovieBookingApp.Repository.MovieRepository;
import com.AccioJob.MovieBookingApp.Repository.ShowRepository;
import com.AccioJob.MovieBookingApp.Repository.TheaterRepository;
import com.AccioJob.MovieBookingApp.converters.ShowConvertors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowRepository showRepository;


    public String addShow(ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowConvertors.showEntryToEntity(showEntryDto);

        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieId()).get();
        showEntity.setMovieEntity(movieEntity);

        TheaterEntity theaterEntity = theaterRepository.findById(showEntryDto.getTheaterId()).get();
        showEntity.setTheaterEntity(theaterEntity);

        List<ShowSeatEntity> showSeatEntityList = addShowSeats(showEntryDto,showEntity);

        showEntity.setShowSeatEntities(showSeatEntityList);

        showEntity = showRepository.save(showEntity);

        movieEntity.getShowEntities().add(showEntity);
        theaterEntity.getShowEntities().add(showEntity);

        movieRepository.save(movieEntity);
        theaterRepository.save(theaterEntity);

        return "The show has been added successfully";
    }
    public List<ShowSeatEntity> addShowSeats(ShowEntryDto showEntryDto,ShowEntity showEntity){

        TheaterEntity theaterEntity = theaterRepository.findById(showEntryDto.getTheaterId()).get();

        List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntity();

        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();

        for (TheaterSeatEntity theaterSeatEntity: theaterSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();
            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatTypes());

            if (theaterSeatEntity.getSeatTypes().equals(SeatType.CLASSIC))
                showSeatEntity.setPrice(showEntryDto.getClassicSeats());
            else{
                showSeatEntity.setPrice(showEntryDto.getPremiumSeats());
            }

            showSeatEntity.setShowEntity(showEntity);

            showSeatEntityList.add(showSeatEntity);
        }
        return showSeatEntityList;
    }

    public LocalTime getShowTime(@RequestBody MovieTheaterEntryDto movieTheaterEntryDto){

        LocalTime showTime = showRepository.findShowByTheaterAndMovie(movieTheaterEntryDto.getMovieId(),movieTheaterEntryDto.getTheaterId());

        return showTime;

    }
}
