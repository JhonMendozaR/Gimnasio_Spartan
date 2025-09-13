package com.exe.gym.Repository;

import com.exe.gym.Entity.PlanTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanTrainerRepository extends JpaRepository<PlanTrainer, Long> {
    List<PlanTrainer> findByPlanId(Long planId);
    List<PlanTrainer> findByTrainerId(Long trainerId);
}