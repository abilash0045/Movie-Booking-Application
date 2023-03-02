package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Entities.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}
