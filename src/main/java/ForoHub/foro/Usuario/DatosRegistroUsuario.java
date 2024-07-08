package ForoHub.foro.Usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank String nombre,
        @NotBlank String correoElectronico,
        @NotBlank String contrasena
) {
}
