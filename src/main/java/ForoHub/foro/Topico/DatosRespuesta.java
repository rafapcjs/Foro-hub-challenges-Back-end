package ForoHub.foro.Topico;

import java.time.LocalDateTime;

public record DatosRespuesta(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime FechaCreacion,
        String status,
        Long autor,
        String curso

) {
}
