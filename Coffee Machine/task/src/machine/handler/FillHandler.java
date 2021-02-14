package machine.handler;

import machine.Stock;

public class FillHandler implements Handler{
    private final Stock stock;
    private Action action = Action.WATER;


    private int water;
    private int milk;
    private int bean;
    private int cup;

    public FillHandler(Stock stock) {
        this.stock = stock;
    }

    private void init() {
        water = 0;
        milk = 0;
        bean = 0;
        cup = 0;
    }

    @Override
    public HandlerResult handle(String input) {
        int val = Integer.parseInt(input);

        if (Action.WATER == action) {
            init();
            water = val;
        } else if (Action.MILK == action) {
            milk = val;
        } else if (Action.BEAN == action) {
            bean = val;
        } else if (Action.CUP == action) {
            cup = val;
            stock.fill(water, milk, bean, cup);
        }
        Handler nextHandler = action.getNextHandler();
        action = action.getNextAction();
        return HandlerResult.builder()
                .nextHandler(nextHandler)
                .build();
    }

    @Override
    public String getStartingMessage() {
        return action.getMessage();
    }

    @Override
    public boolean isHandleMe() {
        return false;
    }

    enum Action {
        CUP("Write how many disposable cups of coffee do you want to add:", "WATER", HandlerHolder.SELECT_ACTION.getHandler()),
        BEAN("Write how many grams of coffee beans do you want to add:", "CUP", null),
        MILK("Write how many ml of milk do you want to add:", "BEAN", null),
        WATER("Write how many ml of water do you want to add:", "MILK", null),
        ;

        private final String message;
        private final String nextAction;
        private final Handler nextHandler;

        Action(String message, String nextAction, Handler nextHandler) {
            this.message = message;
            this.nextAction = nextAction;
            this.nextHandler = nextHandler;
        }

        public String getMessage() {
            return message;
        }

        public Action getNextAction() {
            return Action.valueOf(nextAction);
        }

        public Handler getNextHandler() {
            if (nextHandler == null) {
                return HandlerHolder.FILL.getHandler();
            }
            return nextHandler;
        }
    }


}
