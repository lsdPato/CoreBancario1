package ec.edu.espe.arquitectura.sistema1.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "cuentas")
@TypeAlias("cuentas")
@Data
@Builder
public class Cuenta {

    @Id
    private String id;

    @Indexed(name = "idxu_cuentas_internalId", unique = true)
    private String idCliente;

    private String codigoInterno;

    private BigDecimal saldo;

    private Date fechaUltimoMoviemiento;

    private String estado;

}
