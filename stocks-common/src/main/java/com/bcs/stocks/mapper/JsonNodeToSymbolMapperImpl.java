package com.bcs.stocks.mapper;

import com.bcs.stocks.model.entity.Symbol;
import com.fasterxml.jackson.databind.JsonNode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Mapper(imports = {JsonNode.class, Symbol.class}, componentModel = "spring")
public interface JsonNodeToSymbolMapperImpl extends IMapper<JsonNode, Symbol> {

    @Mapping(target = "", expression = "java(entity.get())")
    @Override
    Symbol entityToDto(JsonNode entity);

    @Override
    JsonNode dtoToEntity(Symbol dto);

    @Override
    Set<Symbol> entitiesToDtoSet(Collection<JsonNode> entities);

    @Override
    Set<JsonNode> dtosToEntitySet(Collection<Symbol> dtos);

    @Override
    List<Symbol> entitiesToDtoList(Collection<JsonNode> entities);

    @Override
    List<JsonNode> dtosToEntityList(Collection<Symbol> dtos);
}
