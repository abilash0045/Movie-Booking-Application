package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    @Query(value = "SELECT movie_entity_id, COUNT(*) AS show_count FROM shows GROUP BY id ORDER BY show_count DESC LIMIT 1",nativeQuery = true)
    public int getMaxShowMovie();
}
