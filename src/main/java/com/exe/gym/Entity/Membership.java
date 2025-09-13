package com.exe.gym.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "membresias")
@Data
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_socio", nullable = false)
    private Partner socio;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_plan", nullable = false)
    private Plan plan;

    @NotNull
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @NotNull
    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private MembershipStatus estado;

    public enum MembershipStatus {
        ACTIVA,
        VENCIDA,
        SUSPENDIDA
    }

}
