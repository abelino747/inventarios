package suarez.abelino.proyectoInventario.entities;

import jakarta.persistence.*;

// Anotación que indica que esta clase es una entidad JPA
@Entity
// Anotación que mapea esta entidad a la tabla "producto" en la base de datos
@Table(name = "producto")
public class ProductoEntity {

    // Anotación que indica que este campo es la clave primaria de la entidad
    @Id
    // Anotación que indica que el valor de este campo es generado automáticamente por la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Campos de la entidad que corresponden a las columnas de la tabla "producto"
    private String nombre;
    private long costo;
    private long precio;
    private double descuento;
    private boolean promocion;
    private String fecha_de_compra;
    private String vencimiento;
    private int unidadesVendidas;
    private int unidadesExistentes;

    // Método getter para el campo id
    public long getId() {
        return id;
    }

    // Método setter para el campo id
    public void setId(long id) {
        this.id = id;
    }

    // Método getter para el campo nombre
    public String getNombre() {
        return nombre;
    }

    // Método setter para el campo nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para el campo costo
    public long getCosto() {
        return costo;
    }

    // Método setter para el campo costo
    public void setCosto(long costo) {
        this.costo = costo;
    }

    // Método getter para el campo precio
    public long getPrecio() {
        return precio;
    }

    // Método setter para el campo precio
    public void setPrecio(long precio) {
        this.precio = precio;
    }

    // Método getter para el campo descuento
    public double getDescuento() {
        return descuento;
    }

    // Método setter para el campo descuento
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    // Método getter para el campo promocion
    public boolean isPromocion() {
        return promocion;
    }

    // Método setter para el campo promocion
    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }

    // Método getter para el campo fecha_de_compra
    public String getFecha_de_compra() {
        return fecha_de_compra;
    }

    // Método setter para el campo fecha_de_compra
    public void setFecha_de_compra(String fecha_de_compra) {
        this.fecha_de_compra = fecha_de_compra;
    }

    // Método getter para el campo vencimiento
    public String getVencimiento() {
        return vencimiento;
    }

    // Método setter para el campo vencimiento
    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    // Método getter para el campo unidadesVendidas
    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    // Método setter para el campo unidadesVendidas
    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    // Método getter para el campo unidadesExistentes
    public int getUnidadesExistentes() {
        return unidadesExistentes;
    }

    // Método setter para el campo unidadesExistentes
    public void setUnidadesExistentes(int unidadesExistentes) {
        this.unidadesExistentes = unidadesExistentes;
    }
}
