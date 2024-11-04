package suarez.abelino.proyectoInventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suarez.abelino.proyectoInventario.entities.ProductoEntity;
import suarez.abelino.proyectoInventario.repository.ProductoRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // listar todos los productos
    public List<ProductoEntity> listar() {
        return productoRepository.findAll();
    }

    // guarda los productos creados
    public ProductoEntity guardarProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }



    // actualizar los productos creados
    public ProductoEntity actualizarProducto(long id, ProductoEntity producto) {
        ProductoEntity productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));

        productoExistente.setNombre(producto.getNombre());
        productoExistente.setCosto(producto.getCosto());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setDescuento(producto.getDescuento());
        productoExistente.setPromocion(producto.isPromocion());
        productoExistente.setFecha_de_compra(producto.getFecha_de_compra());
        productoExistente.setVencimiento(producto.getVencimiento());
        productoExistente.setUnidadesVendidas(producto.getUnidadesVendidas());
        productoExistente.setUnidadesExistentes(producto.getUnidadesExistentes());

        return productoRepository.save(productoExistente);
    }



    // eliminar los productos creados
    public void eliminarProductoPorId(long id) {
        ProductoEntity productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));
        productoRepository.delete(productoExistente);
    }
}
