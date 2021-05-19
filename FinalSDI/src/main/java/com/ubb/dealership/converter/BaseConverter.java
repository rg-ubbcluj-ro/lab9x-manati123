package com.ubb.dealership.converter;

import com.ubb.dealership.core.domain.BaseEntity;
import com.ubb.dealership.dto.Dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseConverter<ID extends Serializable, Model extends BaseEntity<ID>, DTO extends Dto<ID>> implements Converter<ID, Model, DTO> {
    public Set<ID> convertModelsToIDs(Collection<Model> models) {
        return models.stream().map(BaseEntity::getId).collect(Collectors.toSet());
    }

    public Set<ID> convertDTOsToIDs(Collection<DTO> dtos) {
        return dtos.stream().map(Dto::getId).collect(Collectors.toSet());
    }

    public Set<DTO> convertModelsToDTOs(Collection<Model> models) {
        return models.stream().map(this::toDto).collect(Collectors.toSet());
    }

}
