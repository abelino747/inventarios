package suarez.abelino.proyectoInventario.repository;

// Importación de las clases necesarias de Spring Data JPA y Spring
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suarez.abelino.proyectoInventario.entities.ProveedorEntity;

// Anotación @Repository para indicar que esta interfaz es un repositorio Spring
@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
