package suarez.abelino.proyectoInventario.repository;

// Importación de las clases necesarias de Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;
import suarez.abelino.proyectoInventario.entities.ProductoEntity;

// Interfaz que extiende JpaRepository para heredar los métodos CRUD básicos
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
