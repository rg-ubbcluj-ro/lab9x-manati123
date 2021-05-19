package com.ubb.dealership.converter;

import com.ubb.dealership.core.domain.BaseEntity;
import com.ubb.dealership.dto.Dto;


import java.io.Serializable;

public interface Converter <ID extends Serializable, M extends BaseEntity<ID>, D extends Dto<ID>> {
    D toDto(M model);
}