package com.AccioJob.MovieBookingApp.Domain;

import com.AccioJob.MovieBookingApp.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheaterSeatEntity {

    @Id
    private String id;

    private String seatNo;

    private SeatType seatTypes;

}
