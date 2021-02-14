package machine.handler;

public interface Handler {
    HandlerResult handle(String input);
    String getStartingMessage();
    boolean isHandleMe();
}
