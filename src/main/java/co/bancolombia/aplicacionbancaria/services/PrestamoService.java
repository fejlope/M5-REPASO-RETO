package co.bancolombia.aplicacionbancaria.services;

import co.bancolombia.aplicacionbancaria.models.Prestamo;
import co.bancolombia.aplicacionbancaria.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PrestamoService {
    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    // 1. Solicitud de préstamo
    public Prestamo solicitarPrestamo(Prestamo prestamo) {
        prestamo.setEstado(Prestamo.EstadoPrestamo.PENDIENTE);
        return prestamoRepository.save(prestamo);
    }

    // 2. Aprobación/Rechazo de préstamo
    public Optional<Prestamo> aprobarRechazarPrestamo(Long id, Prestamo.EstadoPrestamo estado) {
        Optional<Prestamo> prestamoOpt = prestamoRepository.findById(id);
        prestamoOpt.ifPresent(prestamo -> {
            prestamo.setEstado(estado);
            prestamoRepository.save(prestamo);
        });
        return prestamoOpt;
    }

    // 3. Consulta de estado
    public Optional<Prestamo> consultarEstado(Long id) {
        return prestamoRepository.findById(id);
    }

    // 4. Historial de préstamos de un cliente
    public List<Prestamo> historialPorCliente(Long clienteId) {
        return prestamoRepository.findByClienteId(clienteId);
    }

    // 5. Simulación de cuotas
    public Double calcularCuotaMensual(Double monto, Double interes, Integer duracionMeses) {
        double tasaMensual = interes / 100 / 12;
        return (monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -duracionMeses));
    }
}
