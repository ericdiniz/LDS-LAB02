package com.ldslab02.alugarAutomovel.models.enums;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumContrato {
    CLIENTE(1, "Propriedade do Cliente"),
    BANCO(2, "Propriedade do Banco"),
    EMPRESAS(3, "Propriedade da Empresa");

    private Integer code;
    private String description;

    public static EnumContrato toEnum(Integer code) {
        if (Objects.isNull(code)) {
            return null;
        }
        for (EnumContrato x : EnumContrato.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
