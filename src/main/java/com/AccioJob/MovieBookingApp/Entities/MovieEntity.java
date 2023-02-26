package com.AccioJob.MovieBookingApp.Entities;

import com.AccioJob.MovieBookingApp.Enums.Language;
import com.AccioJob.MovieBookingApp.Enums.MovieGenre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String movieName;

    private double rating;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private MovieGenre movieGenre;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "movieEntity",cascade = CascadeType.ALL)
    List<ShowEntity> showEntities = new ArrayList<>();

}
