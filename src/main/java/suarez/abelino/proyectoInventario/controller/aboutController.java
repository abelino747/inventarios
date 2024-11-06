package suarez.abelino.proyectoInventario.controller;

// Importación de la anotación @Controller de Spring
import org.springframework.stereotype.Controller;
// Importación de la anotación @GetMapping de Spring
import org.springframework.web.bind.annotation.GetMapping;

// Clase controladora anotada con @Controller, indicando que es un controlador Spring MVC
@Controller
public class aboutController {
    // Método que maneja las solicitudes GET a la URL "/about"
    @GetMapping("/about")
    public String dashboard() {
        // Devuelve el nombre de la vista "about"
        return "about";
    }
}









