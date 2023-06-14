package com.AccioJob.MovieBookingApp.Domain;

import com.AccioJob.MovieBookingApp.Enums.Language;
import com.AccioJob.MovieBookingApp.Enums.MovieGenre;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MovieEntity {

    @Id
    private String id;

    private String movieName;

    private double rating;

    private int duration;

    private MovieGenre movieGenre;

    private Language language;

    @JsonIgnore
    @DBRef
    List<ShowEntity> showEntities = new ArrayList<>();

}
