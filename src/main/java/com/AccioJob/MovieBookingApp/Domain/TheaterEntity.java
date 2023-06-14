package com.AccioJob.MovieBookingApp.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheaterEntity {

    @Id
    private String id;

    private String name;

    private String location;

    @DBRef
    private List<TheaterSeatEntity> theaterSeatEntity = new ArrayList<>();

    @DBRef
    private List<ShowEntity> showEntities = new ArrayList<>();
}
