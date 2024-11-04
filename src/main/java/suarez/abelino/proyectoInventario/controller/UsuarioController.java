package suarez.abelino.proyectoInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import suarez.abelino.proyectoInventario.entities.UsuarioEntity;
import suarez.abelino.proyectoInventario.service.UsuarioService;

import java.util.List;

// Anotación que indica que esta clase es un controlador de Spring
@Controller
public class UsuarioController {

    // Declaración del servicio de usuario
    private final UsuarioService usuarioService;

    // Constructor que inyecta la dependencia UsuarioService
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Método para consultar todos los usuarios
    // Define la URL del endpoint
    @GetMapping("/consultarUsuarios")
    public String listarUsuarios(Model model) {
        try {
            // Llama al servicio para obtener la lista de usuarios
            List<UsuarioEntity> usuarios = usuarioService.listar();
            // Añade la lista de usuarios al modelo
            model.addAttribute("usuarios", usuarios);
            // Devuelve el nombre de la vista HTML que se abrirá en el endpoint
            return "crudUsuarios";
        } catch (Exception e) {
            // Manejo de excepciones en caso de error en la consulta
            return "Error en la consulta de usuarios: " + e.getMessage();
        }
    }

    // Método para crear usuarios
    @PostMapping("/guardarUsuarios")
    public String guardarUsuario(@ModelAttribute UsuarioEntity usuario) {
        // Llama al servicio para guardar el usuario
        usuarioService.guardarUsuario(usuario);
        // Redirige a la página de consulta de usuarios
        return "redirect:/consultarUsuarios";
    }

    // Método para modificar usuarios
    @PostMapping("/actualizarUsuarios")
    public String ActualizarUsuario(@ModelAttribute UsuarioEntity usuario) {
        // Llama al servicio para actualizar el usuario
        usuarioService.actualizarUsuario(usuario.getId(), usuario);
        // Redirige a la página de consulta de usuarios
        return "redirect:/consultarUsuarios";
    }

    // Método para eliminar usuarios
    @PostMapping("/eliminarUsuarios")
    public String eliminarUsuario(@RequestParam long id) {
        // Llama al servicio para eliminar el usuario por su ID
        usuarioService.eliminarUsuarioPorId(id);
        // Redirige a la página de consulta de usuarios
        return "redirect:/consultarUsuarios";
    }
}
