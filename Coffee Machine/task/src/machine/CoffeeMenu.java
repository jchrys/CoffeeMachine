package machine;

import java.util.Arrays;

public enum CoffeeMenu {
    BACK(0, 0, 0, 0, 1, 0),
    ESPRESSO(1, 250, 0, 16, 1, 4),
    LATTE(2, 350, 75, 20, 1, 7),
    CAPPUCINO(3, 200, 100, 12, 1, 6),
    UNKNOWN(-1, 0, 0, 0, 1, -1),
    ;

    private int number;
    private Stock stock;

    CoffeeMenu(int number, int water, int milk, int bean, int cup, int money) {
        this.number = number;
        this.stock = new Stock(water, milk, bean, cup, money);
    }

    public int getNumber() {
        return number;
    }

    public Stock getStock() {
       return stock;
    }

    public static CoffeeMenu findByNumber(int number) {
        return Arrays.stream(values())
                .filter(menu -> menu.getNumber() == number)
                .findFirst()
                .orElse(UNKNOWN);
    }
}
