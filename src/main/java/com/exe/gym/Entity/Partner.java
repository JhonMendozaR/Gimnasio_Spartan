package com.exe.gym.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity // Indica que esta clase es una entidad de JPA
@Table(name = "socios") // Si no la pones, JPA toma el nombre de la clase por defecto.
@Getter // Generan automáticamente los métodos getX() para los campos.
@Setter // Generan automáticamente los métodos setX() para los campos.
@NoArgsConstructor // Genera automáticamente el constructor sin parámetros.
@AllArgsConstructor // Genera automáticamente el constructor con todos los parámetros.
// @Data puede causar problemas en entidades JPA por cómo se generan equals/hashCode con colecciones o proxies de Hibernate.
public class Partner {

    @Id // Marca el campo que funciona como clave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor del campo se genera automáticamente.
    private Long id;

    // Nota: @Column(length=...) es lo que define el tamaño físico en la BD
    // @Size es validación a nivel aplicación.

    @NotBlank
    @Size(max = 20)
    @Column(name = "doc", nullable = false, unique = true, length = 20)
    private String doc;

    @NotBlank // Valida que el string no sea null y que, al trimear, tenga al menos 1 caracter (no acepta sólo espacios).
    @Size(max = 50)
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @NotBlank
    @Size(max = 50)
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @NotBlank
    @Email // Valida que el string tenga formato de email.
    @Size(max = 150)
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    // Llave foranea a Membership
    @JsonIgnore
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Membership> membresias = new ArrayList<>();

    // Llave foranea a Attendance
    @JsonIgnore // Para prevenir ciclos infinitos en relaciones bidireccionales.
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attendance> asistencias = new ArrayList<>();

    // Cascade → Propaga operaciones de la entidad padre a las hijas (crear, actualizar, borrar…).
    // Orphan Removal → Elimina automáticamente de la BD los hijos que quitas de la lista del padre (para que no queden registros huérfanos).

    // equals y hashCode solo con id (buena práctica en JPA)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partner)) return false;
        Partner partner = (Partner) o;
        return Objects.equals(id, partner.id);
    }

    @Override // Con @Override, el compilador te dice: “Hey, este método no coincide con ninguno de la clase padre o la interfaz. Revísalo.”
    public int hashCode() {
        return Objects.hash(id);
    }

}
