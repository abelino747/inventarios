package suarez.abelino.proyectoInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import suarez.abelino.proyectoInventario.entities.ProveedorEntity;
import suarez.abelino.proyectoInventario.service.ProveedorService;

import java.util.List;

@Controller
public class ProveedorController {

    private final ProveedorService proveedorService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    // Método para consultar todos los proveedores por defecto
    // Indica a qué URL dirigirse como endpoint
    @GetMapping("/consultarProveedores")
    public String listarProveedores(Model model) {
        try {
            List<ProveedorEntity> proveedores = proveedorService.listar();
            model.addAttribute("proveedores", proveedores);
            // Archivo HTML en el front que se abre en el endpoint
            return "crudProveedores";
        } catch (Exception e) {
            return "Error en la consulta de proveedores: " + e.getMessage();
        }
    }

    // Método para crear proveedores
    @PostMapping("/guardarProveedores")
    public String guardarProveedor(@ModelAttribute ProveedorEntity proveedor) {
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/consultarProveedores";
    }

    // Método para modificar el proveedor
    @PostMapping("/actualizarProveedores")
    public String actualizarProveedor(@ModelAttribute ProveedorEntity proveedor) {
        proveedorService.actualizarProveedor(proveedor.getId(), proveedor);
        return "redirect:/consultarProveedores";
    }

    // Método para eliminar el proveedor
    @PostMapping("/eliminarProveedores")
    public String eliminarProveedor(@RequestParam long id) {
        proveedorService.eliminarProveedorPorId(id);
        return "redirect:/consultarProveedores";
    }
}
