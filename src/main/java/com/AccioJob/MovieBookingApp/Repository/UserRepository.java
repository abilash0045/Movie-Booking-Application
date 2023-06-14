package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Domain.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity,String> {
}
