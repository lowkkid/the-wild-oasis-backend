package com.github.lowkkid.thewildoasisbackend.cabin.mapper;

import com.github.lowkkid.thewildoasisbackend.cabin.model.CabinDTO;
import com.github.lowkkid.thewildoasisbackend.cabin.model.CabinEditRequest;
import com.github.lowkkid.thewildoasisbackend.cabin.domain.entity.Cabin;
import com.github.lowkkid.thewildoasisbackend.cabin.model.CabinCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CabinMapper {
    CabinDTO toDto(Cabin cabin);
    Cabin toEntity(CabinDTO cabinDTO);
    @Mapping(target = "image", ignore = true)
    Cabin toEntity(CabinCreateRequest cabinCreateRequest);
    @Mapping(target = "image", ignore = true)
    Cabin toEntity(CabinEditRequest cabinCreateRequest);
}

