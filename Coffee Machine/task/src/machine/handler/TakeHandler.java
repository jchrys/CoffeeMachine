package machine.handler;

import machine.Stock;

public class TakeHandler implements Handler{

    private final Stock stock;

    public TakeHandler(Stock stock) {
        this.stock = stock;
    }

    @Override
    public HandlerResult handle(String input) {
        return HandlerResult.builder()
                .nextHandler(HandlerHolder.SELECT_ACTION.getHandler())
                .build();
    }

    @Override
    public String getStartingMessage() {
        return "I gave you $" + stock.take();
    }

    @Override
    public boolean isHandleMe() {
        return true;
    }
}
