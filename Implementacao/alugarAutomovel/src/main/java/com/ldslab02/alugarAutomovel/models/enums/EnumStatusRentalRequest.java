package com.ldslab02.alugarAutomovel.models.enums;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumStatusRentalRequest {
    ABERTO(1, "ROLE_EmAberto"),
    ANALISE(2, "ROLE_EmAnalise"),
    EXECUCAO(3, "ROLE_EmExecucao");

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
