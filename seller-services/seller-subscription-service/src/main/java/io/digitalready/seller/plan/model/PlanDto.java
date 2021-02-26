package io.digitalready.seller.plan.model;

import lombok.Data;

@Data
public class PlanDto {
    private String productId;
    private PlanStatus status;
    private String name;
    private String description;
}
