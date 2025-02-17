package co.bancolombia.aplicacionbancaria.models;


import jakarta.persistence.*;

@Entity
@Table(name="prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;


    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "interes",nullable = false)
    private Double interes;

    @Column(name = "duracionmeses", nullable = false)
    private Integer duracionMeses;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado",nullable = false)
    private EstadoPrestamo estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public enum EstadoPrestamo {
        PENDIENTE, APROBADO, RECHAZADO
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Integer getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(Integer duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
