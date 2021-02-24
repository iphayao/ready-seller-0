package io.digitalready.seller.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapping {

    @Mapping(target = "id", ignore = true)
    Product update(Product source, @MappingTarget Product target);

}
