package suarez.abelino.proyectoInventario.entities;

import jakarta.persistence.*;

// Anotación que indica que esta clase es una entidad JPA
@Entity
// Anotación que mapea esta entidad a la tabla "proveedor" en la base de datos
@Table(name = "proveedor")
public class ProveedorEntity {

    // Anotación que indica que este campo es la clave primaria de la entidad
    @Id
    // Anotación que indica que el valor de este campo es generado automáticamente por la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Campos de la entidad que corresponden a las columnas de la tabla "proveedor"
    private String nit;
    private String razonSocial;
    private String direccion;
    private String encargado;
    private String telefono;
    private String correo;
    private String diasPedidos;
    private String diasEntrega;

    // Método getter para el campo id
    public int getId() {
        return id;
    }

    // Método setter para el campo id
    public void setId(int id) {
        this.id = id;
    }

    // Método getter para el campo nit
    public String getNit() {
        return nit;
    }

    // Método setter para el campo nit
    public void setNit(String nit) {
        this.nit = nit;
    }

    // Método getter para el campo razonSocial
    public String getRazonSocial() {
        return razonSocial;
    }

    // Método setter para el campo razonSocial
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    // Método getter para el campo direccion
    public String getDireccion() {
        return direccion;
    }

    // Método setter para el campo direccion
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Método getter para el campo encargado
    public String getEncargado() {
        return encargado;
    }

    // Método setter para el campo encargado
    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    // Método getter para el campo telefono
    public String getTelefono() {
        return telefono;
    }

    // Método setter para el campo telefono
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método getter para el campo correo
    public String getCorreo() {
        return correo;
    }

    // Método setter para el campo correo
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Método getter para el campo diasPedidos
    public String getDiasPedidos() {
        return diasPedidos;
    }

    // Método setter para el campo diasPedidos
    public void setDiasPedidos(String diasPedidos) {
        this.diasPedidos = diasPedidos;
    }

    // Método getter para el campo diasEntrega
    public String getDiasEntrega() {
        return diasEntrega;
    }

    // Método setter para el campo diasEntrega
    public void setDiasEntrega(String diasEntrega) {
        this.diasEntrega = diasEntrega;
    }
}
