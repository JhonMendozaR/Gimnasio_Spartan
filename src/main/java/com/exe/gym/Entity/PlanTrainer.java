package com.exe.gym.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "plan_trainer",
        uniqueConstraints = @UniqueConstraint(name = "uk_plan_trainer", columnNames = {"plan_id", "trainer_id"}),
        indexes = {
                @Index(name = "idx_plan_trainer_plan", columnList = "plan_id"),
                @Index(name = "idx_plan_trainer_trainer", columnList = "trainer_id")
        }
)
@Data
public class PlanTrainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plan_id", nullable = false)
    @JsonIgnore
    private Plan plan;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trainer_id", nullable = false)
    @JsonIgnore
    private Trainer trainer;
}

