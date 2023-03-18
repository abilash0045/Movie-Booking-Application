package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Entities.MovieEntity;
import com.AccioJob.MovieBookingApp.Entities.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {

    @Query(value = "select show_time from shows where movie_entity_id = movieId and theater_entity_id = theaterId",nativeQuery = true)
    public LocalTime findShowByTheaterAndMovie(int movieId,int theaterId);
}
