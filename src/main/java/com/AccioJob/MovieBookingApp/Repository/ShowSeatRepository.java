package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Domain.ShowEntity;
import com.AccioJob.MovieBookingApp.Domain.ShowSeatEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowSeatRepository extends MongoRepository<ShowSeatEntity,String> {

}
