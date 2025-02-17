package co.bancolombia.aplicacionbancaria.repository;

import co.bancolombia.aplicacionbancaria.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByClienteId(Long clienteId);
}
