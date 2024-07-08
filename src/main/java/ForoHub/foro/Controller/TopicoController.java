package ForoHub.foro.Controller;

import ForoHub.foro.Topico.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.data.domain.Pageable;

import java.net.URI;


@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
@SuppressWarnings("all")

public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Operation(summary = "Crea un nuevo tópico")
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        if (topicoRepository.existsByTituloAndMensaje(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Topico topico = new Topico(datosRegistroTopico);

        topico = topicoRepository.save(topico);

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor(),
                topico.getCurso()
        );

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    @Operation(summary = "Obtiene un listado de tópicos existentes")
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 10) @SortDefault.SortDefaults({@SortDefault(sort = ("fechaCreacion"), direction = Sort.Direction.ASC)}) Pageable paginacion) {
        Page<Topico> topicosPage = topicoRepository.findAll(paginacion);
        Page<DatosListadoTopico> datosPage = topicosPage.map(DatosListadoTopico::new);
        return ResponseEntity.ok(datosPage);
    }


    @GetMapping("{id}")
    @Operation(summary = "Obtiene detalles de un tópico por medio del ID indicado")
    public ResponseEntity<DatosRespuesta> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuesta(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Actualiza la información de un tópico")
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());

        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuesta(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        ));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Elimina un tópico por medio del ID")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }


}
