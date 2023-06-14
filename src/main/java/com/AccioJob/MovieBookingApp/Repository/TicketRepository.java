package com.AccioJob.MovieBookingApp.Repository;

import com.AccioJob.MovieBookingApp.Domain.TicketEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<TicketEntity,String> {
}
