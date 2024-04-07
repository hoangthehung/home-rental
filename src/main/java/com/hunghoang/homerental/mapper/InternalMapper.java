package com.hunghoang.homerental.mapper;

import com.hunghoang.homerental.dto.SignupRequest;
import com.hunghoang.homerental.dto.SignupResponse;
import com.hunghoang.homerental.entities.UsersEntity;
import com.hunghoang.homerental.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InternalMapper {
    @Mapping(target = "password", source = "entity.password")
    User toUser(UsersEntity entity);

    @Mapping(target = "name", source = "fullName")
    @Mapping(target = "phone", source = "phoneNumber")
    @Mapping(target = "created", expression = "java(java.time.OffsetDateTime.now())")
    UsersEntity toUsersEntity(SignupRequest dto);

    @Mapping(target = "fullName", source = "entity.name")
    SignupResponse toSignupResponse(UsersEntity  entity);

}
