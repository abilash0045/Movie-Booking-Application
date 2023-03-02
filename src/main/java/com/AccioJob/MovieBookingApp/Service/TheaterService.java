package com.AccioJob.MovieBookingApp.Service;

import com.AccioJob.MovieBookingApp.Entities.TheaterEntity;
import com.AccioJob.MovieBookingApp.Entities.TheaterSeatEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.TheaterEntryDto;
import com.AccioJob.MovieBookingApp.Enums.SeatType;
import com.AccioJob.MovieBookingApp.Repository.TheaterRepository;
import com.AccioJob.MovieBookingApp.converters.TheaterConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    public String add(TheaterEntryDto theaterEntryDto){

        TheaterEntity theaterEntity = TheaterConverters.convertDtoToEntity(theaterEntryDto);

        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto,theaterEntity);

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
                    .theaterEntity(theaterEntity)
                    .build();
            theaterSeatEntityList.add(theaterSeatEntity);
        }

        for (int count =1;count <= premiumSeatsCount;count++){

            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                    .seatTypes(SeatType.PREMIUM)
                    .seatNo(count+"C")
                    .theaterEntity(theaterEntity)
                    .build();
            theaterSeatEntityList.add(theaterSeatEntity);
        }

        return theaterSeatEntityList;
    }
}
