package ForoHub.foro.Topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        @NotNull String titulo,
        @NotNull String mensaje
) {
}
