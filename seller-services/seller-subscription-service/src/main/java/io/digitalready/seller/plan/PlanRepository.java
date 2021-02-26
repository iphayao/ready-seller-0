package io.digitalready.seller.plan;

import io.digitalready.seller.plan.model.Plan;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlanRepository extends ReactiveCrudRepository<Plan, String> {
}
