package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Domain.TheaterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TheaterRepository extends MongoRepository<TheaterEntity,String> {
}
