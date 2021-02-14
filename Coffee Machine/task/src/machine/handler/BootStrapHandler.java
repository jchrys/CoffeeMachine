package machine.handler;

public class BootStrapHandler implements Handler{
    @Override
    public HandlerResult handle(String input) {
        return HandlerResult.builder()
                .nextHandler(HandlerHolder.SELECT_ACTION.getHandler())
                .build();
    }

    @Override
    public String getStartingMessage() {
        return null;
    }

    @Override
    public boolean isHandleMe() {
        return true;
    }
}
