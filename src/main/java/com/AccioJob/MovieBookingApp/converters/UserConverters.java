package com.AccioJob.MovieBookingApp.converters;

import com.AccioJob.MovieBookingApp.Entities.UserEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.UserEntryDto;

public class UserConverters {

    public static UserEntity convertDtoTOEntity(UserEntryDto userEntryDto){
        UserEntity userEntity = UserEntity.builder()
                .age(userEntryDto.getAge())
                .name(userEntryDto.getName())
                .email(userEntryDto.getEmail())
                .mobNo(userEntryDto.getMobNo())
                .address(userEntryDto.getAddress()).build();
        return userEntity;
    }
}
