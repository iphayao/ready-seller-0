package io.digitalready.seller.plan;

import io.digitalready.seller.plan.model.Plan;
import io.digitalready.seller.plan.model.PlanDto;
import io.digitalready.seller.plan.model.mapper.PlanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class PlanService {
    private final PlanRepository planRepository;
    private final PlanMapper planMapper;

    public PlanService(PlanRepository planRepository, PlanMapper planMapper) {
        this.planRepository = planRepository;
        this.planMapper = planMapper;
    }

    public Flux<Plan> getAllPlan() {
        log.info("Get all plan");
        return planRepository.findAll();
    }

    public Mono<Plan> getPlan(String id) {
        log.info("Get plan by ID: {}", id);
        return planRepository.findById(id);
    }

    public Mono<Plan> createPlan(PlanDto plan) {
        log.info("Create plan : {}", plan);
        return planRepository.save(planMapper.toDocument(plan));
    }

    public Mono<Void> deletePlan(String id) {
        log.info("Delete plan by ID: {}", id);
        return planRepository.findById(id)
                .flatMap(planRepository::delete);
    }

    public Mono<Plan> updatePlan(String id, PlanDto plan) {
        log.info("Update plan by ID: {}, {}", id, plan);
        return planRepository.findById(id)
                .flatMap(p -> planRepository.save(planMapper.update(plan, p)));
    }
}
