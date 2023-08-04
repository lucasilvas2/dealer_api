package com.project.dealer_api.domain.order;

public enum OrderStatus {
//    PENDENTE, SOLICITADO_NA_LOJA, CANCELADO,ENTREGUE, AGUARDANDO_PAGAMENTO,PAGO, FINALIZADO;
    PENDENTE(1), SOLICITADO_NA_LOJA(2), CANCELADO(3),ENTREGUE(4), AGUARDANDO_PAGAMENTO(5),PAGO(6), FINALIZADO(7);

    private Integer code;
    private OrderStatus(Integer code){
        this.code = code;
    }

    public Integer getCodeOrderStatus() {
        return code;
    }

    public static OrderStatus valueOf(Integer code){
        for (OrderStatus value : OrderStatus.values()){
            if(code == value.getCodeOrderStatus()){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid RequestSatus code");
    }
}
