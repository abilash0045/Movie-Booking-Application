package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Entities.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}
