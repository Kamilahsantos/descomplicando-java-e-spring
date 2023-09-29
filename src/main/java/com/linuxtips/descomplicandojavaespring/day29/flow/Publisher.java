package flow;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Publisher {

    private static final long TEMPO_PARA_COLETA = 3;

    void entrega(final long clienteAusente1,
                 final long clienteAusente2,
                 final long clienteAusente3,
                 final long clienteAusente4,
                 final long clienteAusente5,
                 final long clienteAusente6,
                 final long clienteAusente7,
                 final long clienteAusente8,
                 final long clienteAusente9,
                 final long clienteAusente10,
                 final int maxItems) throws Exception {
        final SubmissionPublisher<Integer> entregaPedidos =
                new SubmissionPublisher<>(ForkJoinPool.commonPool(), maxItems);


        final Subscriber cliente1 = new Subscriber(
                clienteAusente1,
                Subscriber.CLIENTE_1
        );

        final Subscriber cliente2 = new Subscriber(
                clienteAusente1,
                Subscriber.CLIENTE_2
        );

        final Subscriber cliente3 = new Subscriber(
                clienteAusente1,
                Subscriber.CLIENTE_3
        );

        final Subscriber cliente4 = new Subscriber(
                clienteAusente1,
                Subscriber.CLIENTE_4
        );


        final Subscriber cliente5 = new Subscriber(
                clienteAusente1,
                Subscriber.CLIENTE_5
        );


        final Subscriber cliente6 = new Subscriber(
                clienteAusente1,
                Subscriber.CLIENTE_6
        );


        final Subscriber cliente7 = new Subscriber(
                clienteAusente1,
                Subscriber.CLIENTE_7
        );


        final Subscriber cliente8 = new Subscriber(
                clienteAusente1,
                Subscriber.CLIENTE_8
        );

        final Subscriber cliente9 = new Subscriber(
                clienteAusente1,
                Subscriber.CLIENTE_9
        );

        final Subscriber cliente10 = new Subscriber(
                clienteAusente1,
                Subscriber.CLIENTE_10
        );

        entregaPedidos.subscribe(cliente1);
        entregaPedidos.subscribe(cliente2);
        entregaPedidos.subscribe(cliente3);
        entregaPedidos.subscribe(cliente4);
        entregaPedidos.subscribe(cliente5);
        entregaPedidos.subscribe(cliente6);
        entregaPedidos.subscribe(cliente7);
        entregaPedidos.subscribe(cliente8);
        entregaPedidos.subscribe(cliente9);
        entregaPedidos.subscribe(cliente10);


        System.out.println("Enviando os itens já produzidos pela fábrica" + maxItems + "voce tem  " + TEMPO_PARA_COLETA + "segundos para receber eles");
        IntStream.rangeClosed(1, 10).forEach((number) -> {
            System.out.println("entregando o item " + number + " para o cliente");
            final int deliverLag = entregaPedidos.offer(
                    number,
                    TEMPO_PARA_COLETA,
                    TimeUnit.SECONDS,
                    (customer, response) -> {
                        customer.onError(
                                new RuntimeException("O " + ((Subscriber) customer)
                                        .clientSubscriberName() + "não conseguiu receber no tempo esperado  " + response));
                        return false;
                    });
            if (deliverLag < 0) {
                //itens com falha
                System.out.println("Houve um problema com a entrega, tentaremos novamente mais tarde " + -deliverLag);
            } else {
                System.out.println("Restam  " + deliverLag +
                        " para serem removidos");
            }
        });

        //bloqueia a thread até que todos os assinantes tenham concluído
        while (entregaPedidos.estimateMaximumLag() > 0) {
            Thread.sleep(500L);


        }

        // chame onComplete() de cada subscriber e espere algum tempo até o mais lento concluir também
        entregaPedidos.close();
        Thread.sleep(2000L);

    }


}