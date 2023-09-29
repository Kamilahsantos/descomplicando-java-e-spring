package flow;

public class Main {


    public static void main(String[] args) throws Exception {


        final Publisher flow = new Publisher();

        flow.entrega(1000000000000L, 20000000L, 30000000L, 40000000L, 500000000000000L, 60L, 700L, 800000L, 900000L, 10000000L, 20);

// nano segundos até concluir as entregas
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("A execução levou " + totalTime+ "  nanosegundos");
    }
}
