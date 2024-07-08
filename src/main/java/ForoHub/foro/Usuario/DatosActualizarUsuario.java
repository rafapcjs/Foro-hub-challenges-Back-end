package ForoHub.foro.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull Long id,
        @NotBlank String nombre,
        @NotBlank String correoElectronico,
        @NotBlank String contrasena
){

}
