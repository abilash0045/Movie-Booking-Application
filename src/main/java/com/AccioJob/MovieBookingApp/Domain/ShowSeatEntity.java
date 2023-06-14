package com.AccioJob.MovieBookingApp.Domain;

import com.AccioJob.MovieBookingApp.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeatEntity {

    @Id
    private String id;

    private boolean isBooked;

    private int price;

    private String seatNo;

    private SeatType seatType;

    @CreatedDate
    private Date bookedAt;

}
