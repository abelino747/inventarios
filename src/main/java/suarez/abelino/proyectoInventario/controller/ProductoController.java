package suarez.abelino.proyectoInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import suarez.abelino.proyectoInventario.entities.ProductoEntity;
import suarez.abelino.proyectoInventario.service.ProductoService;

import java.util.List;

@Controller
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // método consultar todos los productos por defecto
    // me dice a qué URL dirigirse como endpoint
    @GetMapping("/consultarProductos")
    public String listarProductos(Model model) {
        try {
            List<ProductoEntity> productos = productoService.listar();
            model.addAttribute("productos", productos);
            // archivo html en el front que se abre en el endpoint
            return "crudProductos";
        } catch (Exception e) {
            return "Error en la consulta de productos " + e.getMessage();
        }
    }

    // método para crear productos
    @PostMapping("/guardarProductos")
    public String guardarProducto(@ModelAttribute ProductoEntity producto) {
        if (producto.getUnidadesExistentes() <= 0) {
            // Manejo de error si unidadesExistentes no está establecido o es inválido
            return "redirect:/consultarProductos?error=unidades_en_existencia_invalido";
        }
        productoService.guardarProducto(producto);
        return "redirect:/consultarProductos";
    }

    // método para modificar el producto
    @PostMapping("/actualizarProductos")
    public String actualizarProducto(@ModelAttribute ProductoEntity producto) {
        if (producto.getUnidadesExistentes() <= 0) {
            // Manejo de error si unidadesExistentes no está establecido o es inválido
            return "redirect:/consultarProductos?error=unidades_en_existencia_invalido";
        }
        productoService.actualizarProducto(producto.getId(), producto);
        return "redirect:/consultarProductos";
    }

    // método para eliminar el producto
    @PostMapping("/eliminarProductos")
    public String eliminarProducto(@RequestParam long id) {
        productoService.eliminarProductoPorId(id);
        return "redirect:/consultarProductos";
    }
}
