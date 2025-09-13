package com.exe.gym.Repository;

import com.exe.gym.Entity.PlanTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanTrainerRepository extends JpaRepository<PlanTrainer, Long> {
}