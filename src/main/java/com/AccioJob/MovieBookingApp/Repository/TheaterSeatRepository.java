package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Domain.TheaterSeatEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatRepository extends MongoRepository<TheaterSeatEntity,String> {
}
