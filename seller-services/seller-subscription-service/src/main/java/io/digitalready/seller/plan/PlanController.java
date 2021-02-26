package io.digitalready.seller.plan;

import io.digitalready.seller.plan.model.Plan;
import io.digitalready.seller.plan.model.PlanDto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/plans")
public class PlanController {
    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public Flux<Plan> getPlans() {
        return planService.getAllPlan();
    }

    @GetMapping("/{id}")
    public Mono<Plan> getPlan(@PathVariable String id) {
        return planService.getPlan(id);
    }

    @PostMapping
    public Mono<Plan> postPlan(@RequestBody PlanDto body) {
        return planService.createPlan(body);
    }

    @PutMapping("/{id}")
    public Mono<Plan> putPlan(@PathVariable String id, @RequestBody PlanDto body) {
        return planService.updatePlan(id, body);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePlan(@PathVariable String id) {
        return planService.deletePlan(id);
    }

}
