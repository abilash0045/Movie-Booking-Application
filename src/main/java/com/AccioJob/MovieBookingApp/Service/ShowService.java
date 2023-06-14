package com.AccioJob.MovieBookingApp.Service;

import com.AccioJob.MovieBookingApp.Domain.*;
import com.AccioJob.MovieBookingApp.EntryDTOs.MovieTheaterEntryDto;
import com.AccioJob.MovieBookingApp.EntryDTOs.ShowEntryDto;
import com.AccioJob.MovieBookingApp.Enums.SeatType;
import com.AccioJob.MovieBookingApp.Repository.MovieRepository;
import com.AccioJob.MovieBookingApp.Repository.ShowRepository;
import com.AccioJob.MovieBookingApp.Repository.ShowSeatRepository;
import com.AccioJob.MovieBookingApp.Repository.TheaterRepository;
import com.AccioJob.MovieBookingApp.converters.ShowConvertors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;


    public String addShow(ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowConvertors.showEntryToEntity(showEntryDto);

        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieId()).get();

        TheaterEntity theaterEntity = theaterRepository.findById(showEntryDto.getTheaterId()).get();

        List<ShowSeatEntity> showSeatEntityList = addShowSeats(showEntryDto,showEntity);

        showEntity.setShowSeatEntities(showSeatEntityList);

        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

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

            showSeatEntityList.add(showSeatRepository.save(showSeatEntity));
        }
        return showSeatEntityList;
    }

    public List<LocalTime> getShowTime(@RequestBody MovieTheaterEntryDto movieTheaterEntryDto){

        Optional<MovieEntity> movieEntity = movieRepository.findById(movieTheaterEntryDto.getMovieId());

        Optional<TheaterEntity> theaterEntity = theaterRepository.findById(movieTheaterEntryDto.getTheaterId());


        List<ShowEntity> showEntities = showRepository.findByMovieEntityAndTheaterEntity(movieEntity.get(),theaterEntity.get());

        List<LocalTime> showTimes = new ArrayList<>();

        for (ShowEntity showEntity : showEntities){
            showTimes.add(showEntity.getShowTime());
        }
        return showTimes;
    }
}
