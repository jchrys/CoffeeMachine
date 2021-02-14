package machine;

public class Stock {
    private int water;
    private int milk;
    private int bean;
    private int cup;
    private int money;

    private static Stock instance = null;

    public static Stock getInstance() {
        if (null == instance) {
            instance = getDefault();
        }
        return instance;
    }

    private static Stock getDefault() {
        return new Stock(400, 540, 120, 9, 550);
    }

    public Stock(int water, int milk, int bean, int cup, int money) {
        this.water = water;
        this.milk = milk;
        this.bean = bean;
        this.cup = cup;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBean() {
        return bean;
    }

    public int getCup() {
        return cup;
    }

    public int getMoney() {
        return money;
    }

    public void fill(int water, int milk, int bean, int cup) {
        this.water += water;
        this.milk += milk;
        this.bean += bean;
        this.cup += cup;
    }

    public int take() {
        int money = this.money;
        this.money = 0;
        return money;
    }

    public boolean withdraw(Stock coffeeMenu) {
        if (!isEnough(coffeeMenu)) {
            return false;
        }
        this.water -= coffeeMenu.getWater();
        this.milk -= coffeeMenu.getMilk();
        this.bean -= coffeeMenu.getBean();
        this.cup -= coffeeMenu.getCup();
        this.money += coffeeMenu.getMoney();
        return true;
    }

    private boolean isEnough(Stock coffeeMenu) {
        if (coffeeMenu.getWater() > water) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (coffeeMenu.getMilk() > milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffeeMenu.getBean() > bean) {
            System.out.println("Sorry, not enough bean!");
            return false;
        } else if (coffeeMenu.getCup() > cup) {
            System.out.println("Sorry, not enough cup!");
            return false;
        }
        return true;
    }

    public String getStatus() {
        return "The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                bean + " of coffee beans\n" +
                cup + " of disposable cups\n" +
                "$" + money + " of money\n";
    }

}
