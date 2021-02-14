package machine;


import machine.handler.Handler;
import machine.handler.HandlerHolder;
import machine.handler.HandlerResult;

public class NewCoffeeMachine {
    private Handler handler = HandlerHolder.BOOT_STRAP.getHandler();

    public void init() {
        handle("");
    }

    public void handle(String input) {
        HandlerResult result = handler.handle(input);
        this.handler = result.getNextHandler();
        String startingMessage = this.handler.getStartingMessage();
        if (StringUtils.isNotEmpty(startingMessage)) {
            System.out.println(startingMessage);
        }
        if (handler.isHandleMe()) {
            handle("");
        }
    }
}
