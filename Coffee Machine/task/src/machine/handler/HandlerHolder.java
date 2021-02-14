package machine.handler;

import machine.Stock;

public enum HandlerHolder {
    BOOT_STRAP(new BootStrapHandler()),
    SELECT_ACTION(new SelectActionHandler()),
    REMAINING(new RemainingHandler(Stock.getInstance())),
    BUY(new BuyHandler(Stock.getInstance())),
    TAKE(new TakeHandler(Stock.getInstance())),
    FILL(new FillHandler(Stock.getInstance())),
    ;

    private final Handler handler;

    HandlerHolder(Handler handler) {
        this.handler = handler;
    }

    public Handler getHandler() {
        return this.handler;
    }

}
