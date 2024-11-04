
package suarez.abelino.proyectoInventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suarez.abelino.proyectoInventario.entities.ProveedorEntity;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
