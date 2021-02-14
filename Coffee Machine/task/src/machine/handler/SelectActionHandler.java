package machine.handler;


import java.util.Arrays;

public class SelectActionHandler implements Handler {
    @Override
    public HandlerResult handle(String input) {
        Handler nextHandler = Arrays.stream(Action.values())
                .filter(value -> value.name().equalsIgnoreCase(input))
                .map(Action::getHandler)
                .findFirst()
                .orElse(Action.RETRY.getHandler());

        return HandlerResult.builder()
                .nextHandler(nextHandler)
                .build();

    }

    @Override
    public String getStartingMessage() {
        return "Write action (buy, fill, take, remaining, exit):";
    }

    @Override
    public boolean isHandleMe() {
        return false;
    }

    enum Action {
        RETRY(HandlerHolder.SELECT_ACTION.getHandler()),
        BUY(HandlerHolder.BUY.getHandler()),
        FILL(HandlerHolder.FILL.getHandler()),
        TAKE(HandlerHolder.TAKE.getHandler()),
        REMAINING(HandlerHolder.REMAINING.getHandler()),
        ;

        private Handler handler;

        Action(Handler handler) {
            this.handler = handler;
        }

        public Handler getHandler() {
            return handler;
        }
    }

}
