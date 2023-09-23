package com.ldslab02.alugarAutomovel.models.enums;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumStatusRentalRequest {
    ABERTO(1, "Em Aberto"),
    ANALISE(2, "Em Analise"),
    EXECUCAO(3, "Em Execucao");

    private Integer code;
    private String description;

    public static EnumStatusRentalRequest toEnum(Integer code) {
        if (Objects.isNull(code)) {
            return null;
        }
        for (EnumStatusRentalRequest x : EnumStatusRentalRequest.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
