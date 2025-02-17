package co.bancolombia.aplicacionbancaria.controllers;

import co.bancolombia.aplicacionbancaria.models.Cliente;
import co.bancolombia.aplicacionbancaria.services.ClienteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
        public List<Cliente> listarClientes() {
            return clienteService.clienteList();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> obtenerCliente(@PathVariable Long id) {

        return clienteService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}