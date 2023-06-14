package com.AccioJob.MovieBookingApp.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    private String id;

    private String name;

    private int age;

    private String email;

    @NonNull
    private String mobNo;

    private String address;

    @DBRef
    private List<TicketEntity> bookedTickets = new ArrayList<>();

    public UserEntity(String id, String name, int age, String email, @NonNull String mobNo, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.mobNo = mobNo;
        this.address = address;
    }
}
