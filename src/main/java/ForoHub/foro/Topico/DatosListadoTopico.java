package ForoHub.foro.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        String titulo,
        String mensage,
        LocalDateTime fechaCreacion,
        Long autor,
        String curso) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getAutor(), topico.getCurso());
    }

}
