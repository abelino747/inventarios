package suarez.abelino.proyectoInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Anotación que indica que esta clase es un controlador de Spring
@Controller
public class LoginController {

    // Declaración de la plantilla JDBC para interactuar con la base de datos
    private final JdbcTemplate jdbcTemplate;

    // Constructor que inyecta la dependencia JdbcTemplate
    @Autowired
    public LoginController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Método que maneja las solicitudes GET a la ruta "/login"
    @GetMapping("/login")
    public String login() {
        return "login"; // Devuelve el nombre de la vista de login
    }

    // Método que maneja las solicitudes POST a la ruta "/login"
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            // Consulta SQL para verificar las credenciales del usuario
            String query = "SELECT COUNT(*) FROM inventarios.usuario WHERE username = ? AND password = ?";
            // Ejecuta la consulta y obtiene el número de filas que coinciden
            int count = jdbcTemplate.queryForObject(query, new Object[]{username, password}, Integer.class);

            if (count > 0) {
                // Si las credenciales son correctas, redirige al dashboard
                return "redirect:/dashboard"; // Redirige a la página de inicio o dashboard
            } else {
                // Si las credenciales son incorrectas, muestra un mensaje de error

                System.out.println(" fallo el logueo ");

                model.addAttribute("error", "Usuario o contraseña incorrectos");
                return "login"; // Devuelve a la página de login con un mensaje de error
            }
        } catch (Exception e) {
            // Manejo de excepciones en caso de error en la consulta
            model.addAttribute("error", "Error en la consulta: " + e.getMessage());
            return "login"; // Devuelve a la página de login con un mensaje de error
        }
    }
}

//funciona hasta aqui sin srping security
