
package suarez.abelino.proyectoInventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControlerServiciosMiPlaza {

    @GetMapping("/servicios")
    public String mostrarServicios(Model model) {
        // Aquí puedes agregar cualquier lógica adicional que necesites
        // Por ejemplo, podrías cargar datos desde una base de datos o un servicio

        // Agregar atributos al modelo si es necesario
        model.addAttribute("titulo", "Servicios - Supermercado Mi-Plaza");

        // Devolver el nombre de la vista que se renderizará
        return "servicios";
    }
}

