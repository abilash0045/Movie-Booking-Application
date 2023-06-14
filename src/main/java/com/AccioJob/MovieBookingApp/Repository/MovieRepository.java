package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Domain.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<MovieEntity,String> {

    MovieEntity findByMovieNameIgnoreCase(String movieName);
}
