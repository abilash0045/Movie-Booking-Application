package com.AccioJob.MovieBookingApp.Service;

import com.AccioJob.MovieBookingApp.Entities.UserEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.UserEntryDto;
import com.AccioJob.MovieBookingApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserEntryDto userEntryDto){

        UserEntity userEntity = UserEntity.builder().age(userEntryDto.getAge()).name(userEntryDto.getName()).email(userEntryDto.getEmail()).mobNo(userEntryDto.getMobNo()).address(userEntryDto.getAddress()).build();

        userRepository.save(userEntity);
    }
}
