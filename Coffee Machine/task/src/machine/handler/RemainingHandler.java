package machine.handler;


import machine.Stock;

public class RemainingHandler implements Handler {

    private final Stock stock;

    public RemainingHandler(Stock stock) {
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
        return stock.getStatus();
    }

    @Override
    public boolean isHandleMe() {
        return true;
    }
}
