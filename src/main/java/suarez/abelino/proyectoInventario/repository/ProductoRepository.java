package suarez.abelino.proyectoInventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import suarez.abelino.proyectoInventario.entities.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

}
