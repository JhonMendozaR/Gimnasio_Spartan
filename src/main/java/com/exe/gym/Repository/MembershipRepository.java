package com.exe.gym.Repository;

import com.exe.gym.Entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    List<Membership> findBySocioIdAndEstado(Long socioId, Membership.MembershipStatus estado);
}