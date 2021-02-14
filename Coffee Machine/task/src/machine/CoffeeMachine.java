package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NewCoffeeMachine newCoffeeMachine = new NewCoffeeMachine();
        newCoffeeMachine.init();
        String input;
        while (!"exit".equals(input = scanner.nextLine())) {
            newCoffeeMachine.handle(input);
        }
    }
}
