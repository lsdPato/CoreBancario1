package ec.edu.espe.arquitectura.sistema1.resource;

import ec.edu.espe.arquitectura.sistema1.model.Transaccion;
import ec.edu.espe.arquitectura.sistema1.service.TransaccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaccion")
@RequiredArgsConstructor
public class TransaccionResource {
  private final TransaccionService service;

  @PostMapping
  public ResponseEntity<Transaccion> create(@RequestBody Transaccion transaccion) {
    try {
      Transaccion crearTransaccion = service.transferir(transaccion);
      return ResponseEntity.ok(crearTransaccion);

    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }

  }
}
