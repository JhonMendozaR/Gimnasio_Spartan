package com.exe.gym.Repository;

import com.exe.gym.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findBySocioId(Long socioId);
    List<Attendance> findByFechaHoraBetween(LocalDateTime start, LocalDateTime end);
}