package suarez.abelino.proyectoInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class prueba {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public prueba(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/pruebaConexion")
    public String data(){
        try {
            jdbcTemplate.execute("SELECT * FROM inventarios.usuario");
            return "conexion exitosa";
        }catch (Exception e){
            return "Error de conexion " + e.getMessage();
        }
    }
}
