package com.teamseven.MusicVillain.Dto.Converter;

import com.teamseven.MusicVillain.Dto.DataTransferObject;
import com.teamseven.MusicVillain.Dto.FeedDto;
import com.teamseven.MusicVillain.Dto.MemberDto;
import com.teamseven.MusicVillain.Feed.Feed;
import com.teamseven.MusicVillain.Member.Member;

public class DtoConverterFactory {
    public static <S, T extends DataTransferObject> DtoConverter<S, T> getConverter(Class<S> sourceClass, Class<? extends T> targetClass) {

        if (sourceClass == Feed.class && targetClass == FeedDto.class) {
            return (DtoConverter<S, T>) new FeedDtoDtoConverter();
        } else if (sourceClass == Member.class && targetClass == MemberDto.class) {
            return (DtoConverter<S, T>) new MemberDtoDtoConverter();
//        } else if (sourceClass == Notification.class && targetClass == NotificationDto.class) {
//            return (Converter<S, T>) new NotificationDtoConverter();
        } else {
            throw new IllegalArgumentException("No suitable converter found.");
        }
    }
}
