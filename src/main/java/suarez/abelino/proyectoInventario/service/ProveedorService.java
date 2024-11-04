package suarez.abelino.proyectoInventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suarez.abelino.proyectoInventario.entities.ProveedorEntity;
import suarez.abelino.proyectoInventario.repository.ProveedorRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    @Autowired
    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    // Listar todos los proveedores
    public List<ProveedorEntity> listar() {
        return proveedorRepository.findAll();
    }

    // Guardar un nuevo proveedor
    public ProveedorEntity guardarProveedor(ProveedorEntity proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Actualizar un proveedor existente
    public ProveedorEntity actualizarProveedor(long id, ProveedorEntity proveedor) {
        ProveedorEntity proveedorExistente = proveedorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Proveedor no encontrado"));

        proveedorExistente.setNit(proveedor.getNit());
        proveedorExistente.setRazonSocial(proveedor.getRazonSocial());
        proveedorExistente.setDireccion(proveedor.getDireccion());
        proveedorExistente.setEncargado(proveedor.getEncargado());
        proveedorExistente.setTelefono(proveedor.getTelefono());
        proveedorExistente.setCorreo(proveedor.getCorreo());
        proveedorExistente.setDiasPedidos(proveedor.getDiasPedidos());
        proveedorExistente.setDiasEntrega(proveedor.getDiasEntrega());

        return proveedorRepository.save(proveedorExistente);
    }

    // Eliminar un proveedor por su ID
    public void eliminarProveedorPorId(long id) {
        ProveedorEntity proveedorExistente = proveedorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Proveedor no encontrado"));
        proveedorRepository.delete(proveedorExistente);
    }
}
