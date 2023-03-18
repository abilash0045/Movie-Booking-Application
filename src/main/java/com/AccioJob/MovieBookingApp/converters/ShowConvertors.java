package com.AccioJob.MovieBookingApp.converters;

import com.AccioJob.MovieBookingApp.Entities.ShowEntity;
import com.AccioJob.MovieBookingApp.EntryDTOs.ShowEntryDto;

public class ShowConvertors {

    public static ShowEntity showEntryToEntity(ShowEntryDto showEntryDto){

        ShowEntity showEntity = ShowEntity.builder().
                showType(showEntryDto.getShowType()).
                showTime(showEntryDto.getShowTime()).
                showDate(showEntryDto.getShowDate()).build();

        return showEntity;
    }
}
