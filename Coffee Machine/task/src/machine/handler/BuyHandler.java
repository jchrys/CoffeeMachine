package machine.handler;

import machine.CoffeeMenu;
import machine.Stock;

public class BuyHandler implements Handler {

    private final Stock stock;

    public BuyHandler(Stock stock) {
        this.stock = stock;
    }

    @Override
    public HandlerResult handle(String input) {
        if (!"back".equalsIgnoreCase(input)) {
            int menu = Integer.parseInt(input);
            Stock coffeeMenu = CoffeeMenu.findByNumber(menu).getStock();
            if (stock.withdraw(coffeeMenu)) {
                System.out.println("I have enough resources, making you a coffee!");
            }
        }
        return HandlerResult.builder()
                .nextHandler(HandlerHolder.SELECT_ACTION.getHandler())
                .build();
    }

    @Override
    public String getStartingMessage() {
        return "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:";
    }

    @Override
    public boolean isHandleMe() {
        return false;
    }

}
