package ForoHub.foro.Topico;

import ForoHub.foro.Respuesta.Respuesta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensaje;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    private String status;


    @JoinColumn(name = "autor", nullable = false)
    private Long autor;


    @JoinColumn(name = "curso", nullable = false)
    private String curso;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;


    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = "Recibido";
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
    }


    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
    if (datosActualizarTopico.titulo() != null){
        this.titulo = datosActualizarTopico.titulo();
    }
    if (datosActualizarTopico.mensaje() != null){
        this.mensaje = datosActualizarTopico.mensaje();
    }

    }
}
