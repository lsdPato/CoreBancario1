package ec.edu.espe.arquitectura.sistema1.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Document(collection = "transacciones")
@TypeAlias("transacciones")
@Data
@Builder
public class Transaccion {
    @Id
    private String id;

    @Indexed(name = "idxu_transacciones_internalId", unique = true)
    private String internalId;

    private Date fecha;

    private String cuentaOrigen;

    private String cuentaDestinatario;

    private BigDecimal valor;

    private String estado;

}
