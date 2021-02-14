package machine.handler;


public class HandlerResult {
    private final Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public HandlerResult(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public static HandlerResultBuilder builder() {
        return new HandlerResultBuilder();
    }

    public static class HandlerResultBuilder {
        private Handler nextHandler;

        public HandlerResultBuilder() {
        }

        public HandlerResultBuilder nextHandler(Handler nextStatus) {
            this.nextHandler = nextStatus;
            return this;
        }

        public HandlerResult build() {
            return new HandlerResult(this.nextHandler);
        }
    }
}
