package flow;

public class Main {


    public static void main(String[] args) throws Exception {


        final Publisher flow = new Publisher();

        flow.entrega(10000L, 20000L, 30000L, 40000L, 50000L, 600L, 700L, 800L, 900L, 1000L, 20);

// nano segundos até concluir as entregas
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("A execução levou " + totalTime+ "  nanosegundos");
    }
}
