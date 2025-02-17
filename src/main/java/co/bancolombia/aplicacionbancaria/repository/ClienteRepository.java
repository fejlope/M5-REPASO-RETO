package co.bancolombia.aplicacionbancaria.repository;

import co.bancolombia.aplicacionbancaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
