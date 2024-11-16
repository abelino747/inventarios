package suarez.abelino.proyectoInventario.entities;

// Importación de las anotaciones de JPA
import jakarta.persistence.*;

// Anotación @Entity para indicar que esta clase es una entidad JPA
@Entity
// Anotación @Table para especificar el nombre de la tabla en la base de datos
@Table(name = "usuario")
public class UsuarioEntity {

    // Anotación @Id para indicar que este campo es la clave primaria
    @Id
    // Anotación @GeneratedValue para especificar la estrategia de generación de la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String correo;
    private String telefono;
    private String cargo;
    private String password;

    private   String username ;

    // Getters y setters para los campos de la entidad

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
