package ForoHub.foro.Usuario;

import ForoHub.foro.Topico.Topico;

public record DatosListadoUsuario(
        Long id,
        String nombre,
        String correoElectronico
) {

    public DatosListadoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico());
    }


}
