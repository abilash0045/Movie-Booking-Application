package com.AccioJob.MovieBookingApp.converters;

import com.AccioJob.MovieBookingApp.Domain.UserEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.UserEntryDto;

public class UserConverters {

    public static UserEntity convertDtoTOEntity(UserEntryDto userEntryDto){
        UserEntity userEntity = new UserEntity();
                userEntity.setName(userEntryDto.getName());
                return userEntity;
    }
}
