package suarez.abelino.proyectoInventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suarez.abelino.proyectoInventario.entities.UsuarioEntity;
import suarez.abelino.proyectoInventario.repository.UsuarioRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository= usuarioRepository;
    }
    //listar todos los usuarios
    public List <UsuarioEntity> listar (){
        return usuarioRepository.findAll();
    }

    // guarda los usuarios creados
    public UsuarioEntity guardarUsuario (UsuarioEntity usuario){
        return usuarioRepository.save(usuario);
    }


    // actualizar los usuarios creados
    public UsuarioEntity actualizarUsuario (long id,UsuarioEntity usuario){
        UsuarioEntity usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(( )-> new NoSuchElementException("Usuario no encontrado "));
                usuarioExistente.setNombre(usuario.getNombre());
                usuarioExistente.setCorreo(usuario.getCorreo());
                usuarioExistente.setTelefono(usuario.getTelefono());
                usuarioExistente.setCargo(usuario.getCargo());
                usuarioExistente.setPassword(usuario.getPassword());
                usuarioExistente.setUsername(usuario.getUsername());

                return usuarioRepository.save(usuarioExistente);
    }


    // eliminar los usuarios creados
    public void eliminarUsuarioPorId (long id){
        UsuarioEntity usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(( )-> new NoSuchElementException("Usuario no encontrado "));
        usuarioRepository.delete(usuarioExistente);
    }


}
// funciona hasta aqui sin codificar la contraseña