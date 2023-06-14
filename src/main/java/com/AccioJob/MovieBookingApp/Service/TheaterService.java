package com.AccioJob.MovieBookingApp.Service;

import com.AccioJob.MovieBookingApp.Domain.ShowEntity;
import com.AccioJob.MovieBookingApp.Domain.TheaterEntity;
import com.AccioJob.MovieBookingApp.Domain.TheaterSeatEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.GetTheatersShowingDto;
import com.AccioJob.MovieBookingApp.EntryDTOs.TheaterEntryDto;
import com.AccioJob.MovieBookingApp.Enums.SeatType;
import com.AccioJob.MovieBookingApp.Repository.ShowRepository;
import com.AccioJob.MovieBookingApp.Repository.TheaterRepository;
import com.AccioJob.MovieBookingApp.Repository.TheaterSeatRepository;
import com.AccioJob.MovieBookingApp.converters.TheaterConverters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class TheaterService {


    Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public String add(TheaterEntryDto theaterEntryDto){

        TheaterEntity theaterEntity = TheaterConverters.convertDtoToEntity(theaterEntryDto);

        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto,theaterEntity);

        logger.info("Created seats " + theaterSeatEntityList.toString());

        theaterEntity.setTheaterSeatEntity(theaterSeatEntityList);

        theaterRepository.save(theaterEntity);

        return "Theater added successfully";
    }

    public List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto,TheaterEntity theaterEntity){

        int classicSeatsCount = theaterEntryDto.getClassicSeatsCount();
        int premiumSeatsCount = theaterEntryDto.getPremiumSeatsCount();

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        for (int count = 1; count <= classicSeatsCount;count++){

            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                    .seatTypes(SeatType.CLASSIC)
                    .seatNo(count + "C")
                    .build();
            theaterSeatEntityList.add(theaterSeatRepository.save(theaterSeatEntity));
        }

        for (int count =1;count <= premiumSeatsCount;count++){

            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                    .seatTypes(SeatType.PREMIUM)
                    .seatNo(count+"C")
                    .build();
            theaterSeatEntityList.add(theaterSeatRepository.save(theaterSeatEntity));
        }

        return theaterSeatEntityList;
    }

    public int getCountOfUniqueLocation(String theaterName){

        List<TheaterEntity> theaterEntities = theaterRepository.findAll();

        HashSet<String> locations = new HashSet<>();

        for (TheaterEntity theaterEntity : theaterEntities){

            if (theaterEntity.getName().equals(theaterName)){
                locations.add(theaterEntity.getLocation());
            }
        }
        return locations.size();
    }

    public List<TheaterEntity> getTheatersForShowTime(GetTheatersShowingDto getTheatersShowingDto){

        List<TheaterEntity> theaterEntities = new ArrayList<>();

        List<ShowEntity> showEntities = showRepository.findAll();

        for (ShowEntity showEntity : showEntities){

            if (showEntity.getShowTime().equals(getTheatersShowingDto.getTime())){

                theaterEntities.add(showEntity.getTheaterEntity());
            }
        }

        return theaterEntities;
    }
}
