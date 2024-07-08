package ForoHub.foro.Respuesta;

import ForoHub.foro.Topico.Topico;
import ForoHub.foro.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "respuesta")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "topico", nullable = false)
    private Topico topico;

    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "autor", nullable = false)
    private Usuario autor;

    private Boolean solucion;


}
