package com.AccioJob.MovieBookingApp.Service;

import com.AccioJob.MovieBookingApp.Domain.UserEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.UserEntryDto;
import com.AccioJob.MovieBookingApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.AccioJob.MovieBookingApp.converters.UserConverters.convertDtoTOEntity;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto) throws Exception{

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userEntryDto.getName());;
        userRepository.save(userEntity);

        return "User added successfully";
    }
}
