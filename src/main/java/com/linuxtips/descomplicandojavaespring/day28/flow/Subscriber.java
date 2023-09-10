package flow;

import java.util.concurrent.Flow;
import java.util.stream.IntStream;

public class Subscriber implements Flow.Subscriber<Integer> {

    public static final String CLIENTE_1 = "Cliente 1";
    public static final String CLIENTE_2 = "Cliente 2";
    public static final String CLIENTE_3 = "Cliente 3";
    public static final String CLIENTE_4 = "Cliente 4";
    public static final String CLIENTE_5 = "Cliente 5";
    public static final String CLIENTE_6 = "Cliente 6";
    public static final String CLIENTE_7 = "Cliente 7";
    public static final String CLIENTE_8 = "Cliente 8";
    public static final String CLIENTE_9 = "Cliente 9";
    public static final String CLIENTE_10 = "Cliente 10";


    private final Long tempoAusente;
    private final String nomeCliente;
    private int proximoPedido;
    private int totalItens;
    private Flow.Subscription clientSubscription;


    public Subscriber(Long tempoAusente, String nomeCliente) {
        this.tempoAusente = tempoAusente;
        this.nomeCliente = nomeCliente;
        this.proximoPedido = 1;
        this.totalItens = 0;
    }


    @Override
    public void onSubscribe(Flow.Subscription clientSubscription) {
        this.clientSubscription = clientSubscription;
        clientSubscription.request(1);
    }

    @Override
    public void onNext(final Integer itemNumber) {
        if (itemNumber != proximoPedido) {
            IntStream.range(proximoPedido, itemNumber).forEach(
                    (orderItemNumber) ->
                            System.out.println("Cliente ausente entrega não concluída " + orderItemNumber)
            );
            proximoPedido = itemNumber;
        }
        System.out.println("Item removido e entregue com sucesso " + itemNumber);
        ficarAusente();
        proximoPedido++;
        totalItens++;

        System.out.println("Próximo pedido a ser entregue  " +
                proximoPedido);
        clientSubscription.request(1);
    }


    @Override
    public void onError(Throwable throwable) {
        System.out.println("Tivemos um problema para concluir esta entrega, desculpe o transtorno " + throwable.getMessage());

    }


    @Override
    public void onComplete() {
        System.out.println("Recebi todos os itens do meu pedido, foram   "  +
                totalItens + " no total");
    }


    private void ficarAusente() {
        try {
            Thread.sleep(tempoAusente);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String clientSubscriberName() {
        return nomeCliente;
    }
}


