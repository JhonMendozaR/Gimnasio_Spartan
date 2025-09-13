package com.exe.gym.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "entrenadores")
@Data
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @NotBlank
    @Size(max = 120)
    @Column(name = "especialidad", nullable = false, length = 120)
    private String especialidad;

    @JsonIgnore
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlanTrainer> planTrainers = new HashSet<>();

}
