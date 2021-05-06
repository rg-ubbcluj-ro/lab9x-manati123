package web.converter;

import core.domain.BaseEntity;
import web.dto.Dto;

import java.io.Serializable;

public interface Converter <ID extends Serializable, Model extends BaseEntity<ID>, DTO extends Dto<ID>>{
    Model convertDtoToModel(DTO dto);

    DTO convertModelToDto(Model model);
}