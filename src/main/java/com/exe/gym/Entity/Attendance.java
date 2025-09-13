package com.exe.gym.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "asistencias")
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_socio", nullable = false)
    private Partner socio;

    @NotNull
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

}
