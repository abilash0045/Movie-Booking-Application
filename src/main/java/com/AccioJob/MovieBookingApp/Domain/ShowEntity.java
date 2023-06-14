package com.AccioJob.MovieBookingApp.Domain;


import com.AccioJob.MovieBookingApp.Enums.ShowType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowEntity {

    @Id
    private String id;

    private LocalDate showDate;

    private LocalTime showTime;

    private ShowType showType;

    @CreatedDate
    private Date createdOn;

    @CreatedDate
    private Date updatedOn;

    @DBRef
    private MovieEntity movieEntity;

    @DBRef
    private TheaterEntity theaterEntity;

    @DBRef
    private List<TicketEntity> ticketEntities = new ArrayList<>();

    @DBRef
    private List<ShowSeatEntity> showSeatEntities = new ArrayList<>();
}
