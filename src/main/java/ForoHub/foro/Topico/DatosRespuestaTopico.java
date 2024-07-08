package ForoHub.foro.Topico;


import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        String titulo,
        String mensaje,
        LocalDateTime FechaCreacion,
        Long autor,
        String curso

) {
}
