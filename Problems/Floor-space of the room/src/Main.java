import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Shape shape = Shape.findByNameIgnoreCases(input);
        List<Double> variables = new ArrayList<>();
        for (int i = 0; i < shape.getInputNumber(); ++i) {
            variables.add(Double.parseDouble(scanner.nextLine()));
        }
        System.out.print(shape.getEquation().apply(variables));
    }

    public static enum Shape {
        TRIANGLE(3, list -> {
            Double s = (list.get(0) + list.get(1) + list.get(2)) / 2D;
            return Math.sqrt(s * (s - list.get(0)) * (s - list.get(1)) * (s - list.get(2)));
        }),
        RECTANGLE(2, list -> {
            return list.get(0) * list.get(1);
        }),
        CIRCLE(1, list -> {
            return list.get(0) * list.get(0) * 3.14D;
        }),
        UNKNOWN(0, list -> null);


        private int inputNumber;
        private Function<List<Double>, Double> equation;

        Shape(int inputNumber, Function<List<Double>, Double> equation) {
            this.inputNumber = inputNumber;
            this.equation = equation;
        }

        public int getInputNumber() {
            return inputNumber;
        }

        public Function<List<Double>, Double> getEquation() {
            return equation;
        }

        public static Shape findByNameIgnoreCases(String name) {
            return Arrays.stream(values())
                    .filter(e -> e.name().equalsIgnoreCase(name))
                    .findFirst().orElse(UNKNOWN);
        }
    }
}