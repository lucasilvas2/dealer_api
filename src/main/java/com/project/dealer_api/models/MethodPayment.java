package com.project.dealer_api.models;

public enum MethodPayment {
    ESPECIE(1), ESPECIE_PARELADO(2),CARTAO_DEBITO(3), CARTAO_PARCELADO(4), PIX(5), PIX_PARCELADO(6);

    private int code;
    private MethodPayment (int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static  MethodPayment valueOf(int code){
        for ( MethodPayment  value :  MethodPayment.values()){
            if(code == value.getCode()){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid RequestSatus code");
    }
}
