package ForoHub.foro.Topico;

import ForoHub.foro.Curso.Curso;
import ForoHub.foro.Usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long autor,
        @NotBlank String curso

) {
}
