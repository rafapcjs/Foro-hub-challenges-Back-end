package ForoHub.foro.Usuario;

import ForoHub.foro.Topico.DatosRegistroTopico;
import ForoHub.foro.Topico.DatosRespuestaTopico;
import ForoHub.foro.Topico.Topico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.data.domain.Pageable;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
@SuppressWarnings("all")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    @Operation(summary = "Obtener lista de usuarios")
    public ResponseEntity<Page<DatosListadoUsuario>> listadoUsuarios(@PageableDefault(size = 10) Pageable paginacion) {
        Page<Usuario> usuarioPage = usuarioRepository.findAll(paginacion);
        Page<DatosListadoUsuario> datosPage = usuarioPage.map(DatosListadoUsuario::new);
        return ResponseEntity.ok(datosPage);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener detalles de usuario por medio del ID indicado")
    public ResponseEntity<DatosRespuestaUsuario> retornaDatosMedico(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        var datosUsuario = new DatosRespuestaUsuario(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreoElectronico(),
                usuario.getContrasena()
        );
        return ResponseEntity.ok(datosUsuario);

    }


    @PutMapping
    @Transactional
    @Operation(summary = "Actualiza la información para el usuario")
    public ResponseEntity actualizarUsuario(@RequestBody @Validated DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarDatos(datosActualizarUsuario);
        return ResponseEntity.ok(new DatosRespuestaUsuario(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreoElectronico(),
                usuario.getContrasena()
        ));
    }

    @PostMapping
    @Operation(summary = "Registra un nuevo usuario")
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario, UriComponentsBuilder uriComponentsBuilder) {
        if (usuarioRepository.existsByNombreAndContrasena(datosRegistroUsuario.nombre(), datosRegistroUsuario.contrasena())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Usuario usuario = new Usuario(datosRegistroUsuario);

        usuario = usuarioRepository.save(usuario);

        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreoElectronico(),
                usuario.getContrasena()
        );

        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaUsuario);
    }

    @Operation(summary = "Elimina cierto usuario por medio del ID")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id) {
        if (usuarioRepository.findById(id).isPresent()) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}

