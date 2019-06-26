package com.bcs.stocks.mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Common interface for mappers
 *
 * @param <E> entity
 * @param <D> dto
 */
public interface IMapper<E, D extends Serializable> {

  D entityToDto(E entity);

  E dtoToEntity(D dto);

  Set<D> entitiesToDtoSet(Collection<E> entities);

  Set<E> dtosToEntitySet(Collection<D> dtos);

  List<D> entitiesToDtoList(Collection<E> entities);

  List<E> dtosToEntityList(Collection<D> dtos);
}
