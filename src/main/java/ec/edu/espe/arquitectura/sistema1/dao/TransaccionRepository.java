package ec.edu.espe.arquitectura.sistema1.dao;

import ec.edu.espe.arquitectura.sistema1.model.Transaccion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TransaccionRepository extends MongoRepository<Transaccion, String> {
    Optional<Transaccion> findByInternalId(String internalId);
}
