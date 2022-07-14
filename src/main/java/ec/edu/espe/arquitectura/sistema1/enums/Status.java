package ec.edu.espe.arquitectura.sistema1.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Status {
    ACTIVE("ACT", "Activo"),
    INACTIVE("INA", "Inactivo");

    private final String value;
    private final String text;
}
