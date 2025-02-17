package co.bancolombia.aplicacionbancaria.controllers;


import co.bancolombia.aplicacionbancaria.models.Prestamo;
import co.bancolombia.aplicacionbancaria.services.ClienteService;
import co.bancolombia.aplicacionbancaria.services.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {this.prestamoService = prestamoService;    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> consultarEstado(@PathVariable Long id) {
        return prestamoService.consultarEstado(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Prestamo>> historialPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(prestamoService.historialPorCliente(clienteId));
    }

    @GetMapping("/simulacion")
    public ResponseEntity<Double> simularCuota(@RequestParam Double monto, @RequestParam Double interes, @RequestParam Integer duracionMeses) {
        return ResponseEntity.ok(prestamoService.calcularCuotaMensual(monto, interes, duracionMeses));
    }

    // -----------------------------------------------------------------------------------

    // 1. Solicitar préstamo
    @PostMapping("/crear")
    public ResponseEntity<Prestamo> solicitarPrestamo(@RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(prestamoService.solicitarPrestamo(prestamo));
    }

    // 2. Aprobar/Rechazar préstamo
    @PutMapping("/{id}/estado")
    public ResponseEntity<Prestamo> actualizarEstado(@PathVariable Long id, @RequestParam Prestamo.EstadoPrestamo estado) {
        return prestamoService.aprobarRechazarPrestamo(id, estado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}

