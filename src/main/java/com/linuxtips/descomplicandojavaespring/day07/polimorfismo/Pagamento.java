package com.linuxtips.descomplicandojavaespring.day07.polimorfismo;

//exemplo de sobrecarga
public class Pagamento {


    //pagamento a vista
    public Double pagamento(Double valor){
        return valor;
    }


    //calcula o valor das parcelas
    public Integer pagamento(Integer valorInteger, Integer parcelas ){
        return valorInteger/parcelas;
    }

    //juros
    public Long pagamento(Integer valorInteger, Integer parcelas, Long juros){
        return (valorInteger/parcelas) + juros;
    }


}
