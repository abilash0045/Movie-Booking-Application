package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
}
