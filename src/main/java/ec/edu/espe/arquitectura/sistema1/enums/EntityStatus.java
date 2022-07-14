package ec.edu.espe.arquitectura.sistema1.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EntityStatus {

    ACTIVE("EJE", "Ejecutando"),
    INACTIVE("Bloqueado", "bloqueado");

    private final String value;
    private final String text;
}
