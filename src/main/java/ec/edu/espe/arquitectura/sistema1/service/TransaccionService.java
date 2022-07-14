package ec.edu.espe.arquitectura.sistema1.service;

import ec.edu.espe.arquitectura.sistema1.dao.CuentaRepository;
import ec.edu.espe.arquitectura.sistema1.dao.TransaccionRepository;
import ec.edu.espe.arquitectura.sistema1.enums.EntityStatus;
import ec.edu.espe.arquitectura.sistema1.model.Cuenta;
import ec.edu.espe.arquitectura.sistema1.model.Transaccion;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransaccionService {
  private final CuentaRepository cuentaRepository;
  private final TransaccionRepository transaccionRepository;

  public Cuenta findByInternalId(String clienteId) throws ChangeSetPersister.NotFoundException {
    return cuentaRepository
        .findByIdCliente(clienteId)
        .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
  }

  public Transaccion transferir(Transaccion transaccion) {

    Optional<Cuenta> cuentaOrigenBd =
        this.cuentaRepository.findByIdCliente(transaccion.getCuentaOrigen());
    Optional<Cuenta> cuentaDestinoBd =
        this.cuentaRepository.findByIdCliente(transaccion.getCuentaDestinatario());

    if (cuentaOrigenBd.isPresent()) {}
    if (cuentaDestinoBd.isPresent()) {}
    cuentaOrigenBd
        .get()
        .setSaldo(cuentaOrigenBd.get().getSaldo().subtract(transaccion.getValor()));
    cuentaDestinoBd
        .get()
        .setSaldo(cuentaOrigenBd.get().getSaldo().add(transaccion.getValor()));
    transaccion.setEstado(EntityStatus.ACTIVE.getText());
    transaccion.setFecha(new Date());
    transaccion.setCuentaOrigen(cuentaOrigenBd.get().getIdCliente());
    transaccion.setCuentaDestinatario(cuentaDestinoBd.get().getIdCliente());
    transaccion.setValor(transaccion.getValor());


    return this.transaccionRepository.save(transaccion);
  }
}
