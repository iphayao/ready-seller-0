package io.digitalready.seller.plan.model.mapper;

import io.digitalready.seller.plan.model.Plan;
import io.digitalready.seller.plan.model.PlanDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlanMapper {

    Plan toDocument(PlanDto dto);

    Plan update(PlanDto source, @MappingTarget Plan target);

}
