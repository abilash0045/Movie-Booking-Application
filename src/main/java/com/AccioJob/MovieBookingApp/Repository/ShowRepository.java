package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Domain.MovieEntity;
import com.AccioJob.MovieBookingApp.Domain.ShowEntity;
import com.AccioJob.MovieBookingApp.Domain.TheaterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends MongoRepository<ShowEntity,String> {

    List<ShowEntity> findByMovieEntityAndTheaterEntity(MovieEntity movieEntity, TheaterEntity theaterEntity);
}
