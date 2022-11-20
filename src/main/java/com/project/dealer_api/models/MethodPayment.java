package com.project.dealer_api.models;

public enum MethodPayment {
    ESPECIE(1), ESPECIE_PARELADO(2),CARTAO_DEBITO(3), CARTAO_PARCELADO(4), PIX(5), PIX_PARCELADO(6);

    private Integer code;
    private MethodPayment(Integer code){
        this.code = code;
    }

    public Integer getCodeMethod() {
        return code;
    }

    public static MethodPayment valueOf(Integer code){
        for (MethodPayment value : MethodPayment.values()){
            if(code == value.getCodeMethod()){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid RequestSatus code");
    }
}

