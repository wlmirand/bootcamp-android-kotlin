package venturus.org.br.playground.samples.hof;

public class JavaInterfaceSample {

    public static void main(String[] args) {

        final JavaMyListener listener = new JavaMyListener() {
            @Override
            public void printNumber(int number) {
                System.out.println("Found " + number);
            }
        };

        findNumber(listener);
    }

    private static void findNumber(JavaMyListener listener) {
        listener.printNumber(108);
    }

    interface JavaMyListener {

        void printNumber(int number);
    }
}
