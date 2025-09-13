package com.exe.gym.Repository;

import com.exe.gym.Entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Optional<Partner> findByDoc(String doc); // búsqueda exacta por documento.
    Optional<Partner> findByEmail(String email); // búsqueda exacta por correo electrónico.
    boolean existsByDoc(String doc); // Verifica si un socio con ese documento ya existe.
    // booleans → Validar duplicados
    boolean existsByEmail(String email); // Verifica si un socio con ese email ya existe.
    List<Partner> findByNombresContainingIgnoreCase(String nombres); // búsqueda parcial y sin importar mayúsculas en los nombres.
    List<Partner> findByApellidosContainingIgnoreCase(String apellidos); // búsqueda parcial y sin importar mayúsculas en los apellidos.
    Optional<Partner> findByDocAndEmail(String doc, String email); // búsqueda exacta combinando documento y correo.
    Optional<Partner> findByNombresAndApellidos(String nombres, String apellidos); // búsqueda exacta combinando nombres y apellidos.
    Page<Partner> findByNombresContainingIgnoreCase(String nombres, Pageable pageable); // búsqueda parcial con paginación.
}

// findByDoc = SELECT * FROM socios WHERE doc = ?;