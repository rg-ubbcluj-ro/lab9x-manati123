package com.ubb.dealership.dto;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class CollectionDto<ID extends Serializable, D extends Dto<ID>> {
    List<D> elements;
}