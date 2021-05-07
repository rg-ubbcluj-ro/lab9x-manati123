package web.converter;

import core.domain.BaseEntity;
import web.dto.Dto;

import java.io.Serializable;

import java.io.Serializable;

public interface Converter<ID extends Serializable, M, D extends Dto<ID>> {
    D toDto(M model);
}