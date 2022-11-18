package com.project.dealer_systeam.models;

public enum RequestStatus {
    PENDENTE(1), SOLICITADO_NA_LOJA(2), CANCELADO(3),ENTREGUE(4), AGUARDANDO_PAGAMENTO(5),PAGO(6), FINALIZADO(7);

    private int code;
    private RequestStatus (int code){
         this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static RequestStatus valueOf(int code){
        for (RequestStatus  value : RequestStatus.values()){
            if(code == value.getCode()){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid RequestSatus code");
    }
}
