package com.bcs.stocks.mapper;

import com.bcs.stocks.model.entity.Symbol;
import com.fasterxml.jackson.databind.JsonNode;

/*@Mapper(imports = {JsonNode.class, Symbol.class, BigDecimal.class}, componentModel = "spring")*/
public interface NodeSymbolMapperImpl extends IMapper<JsonNode, Symbol> {

//    @Mapping(target = "symbol", expression = "java(node.path(\"symbol\").asText())")
//    @Mapping(target = "sector", expression = "java(node.path(\"sector\").asText())")
//    @Mapping(target = "securityType", expression = "java(node.path(\"securityType\").asText())")
//    @Mapping(target = "bidPrice", expression = "java(BigDecimal.valueOf(node.path(\"bidPrice\")))")
//    @Mapping(target = "bidSize", expression = "java(node.path(\"bidSize\").asInt())")
//    @Mapping(target = "askPrice", expression = "java(BigDecimal.valueOf(node.path(\"askPrice\")))")
//    @Mapping(target = "askSize", expression = "java(node.path(\"askSize\").asInt())")
//    @Mapping(target = "lastUpdated", expression = "java(node.path(\"lastUpdated\").asLong())")
//    @Mapping(target = "lastSalePrice", expression = "java(BigDecimal.valueOf(node.path(\"lastSalePrice\")))")
//    @Mapping(target = "lastSaleSize", expression = "java(node.path(\"lastSaleSize\").asInt())")
//    @Mapping(target = "lastSaleTime", expression = "java(node.path(\"lastSaleTime\").asLong())")
//    @Mapping(target = "volume", expression = "java(node.path(\"volume\").asLong())")
//    @Mapping(target = "marketPercent", expression = "java(BigDecimal.valueOf(node.path(\"marketPercent\")))")
//    @Override
//    Symbol entityToDto(JsonNode node);
//
//    @Override
//    JsonNode dtoToEntity(Symbol dto);
//
//    @Override
//    Set<Symbol> entitiesToDtoSet(Collection<JsonNode> nodes);
//
//    @Override
//    Set<JsonNode> dtosToEntitySet(Collection<Symbol> dtos);
//
//    @Override
//    List<Symbol> entitiesToDtoList(Collection<JsonNode> nodes);
//
//    @Override
//    List<JsonNode> dtosToEntityList(Collection<Symbol> dtos);
}
