package suarez.abelino.proyectoInventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suarez.abelino.proyectoInventario.entities.UsuarioEntity;

/**
 * Interfaz de repositorio para la entidad UsuarioEntity.
 * Esta interfaz extiende JpaRepository, lo que proporciona métodos CRUD predefinidos.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    /**
     * Método personalizado para buscar un usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario del usuario que se desea buscar.
     * @return La entidad UsuarioEntity correspondiente al nombre de usuario proporcionado.
     */
    UsuarioEntity findByUsername(String username);
}

