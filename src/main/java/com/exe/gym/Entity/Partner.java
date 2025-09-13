package com.exe.gym.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "socios")
@Data
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "doc", nullable = false, unique = true, length = 20)
    private String doc;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @NotBlank
    @Size(max = 100)
    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @NotBlank
    @Email
    @Size(max = 150)
    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Membership> membresias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attendance> asistencias = new ArrayList<>();

}
