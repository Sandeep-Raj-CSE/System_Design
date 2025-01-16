package DecoratorDesignPattern;

// Coffee Shop

interface Coffee {
    String getDescription();
    double getCost();
}

// Plain Coffee

class PlainCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Plain Coffee";
    }

    @Override
    public double getCost() {
        return 20.0;
    }
}

// Abstract Decorator Class

abstract class DecoratorCoffee implements Coffee {
    protected Coffee coffee;

    public DecoratorCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}

// Milk Decorator

class Milk extends DecoratorCoffee {

    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 5.0;
    }
}

// Sugar Decorator

class Sugar extends DecoratorCoffee {

    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 3.0;
    }
}

public class DecoratorPattern {

    public static void main(String[] args) {
        Coffee coffee = new PlainCoffee();

        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Price: " + coffee.getCost());

        // Add milk to the coffee
        Coffee milkCoffee = new Milk(coffee);
        System.out.println("Description: " + milkCoffee.getDescription());
        System.out.println("Price: " + milkCoffee.getCost());

        // Add sugar and milk to the coffee
        Coffee sugarMilkCoffee = new Sugar(milkCoffee);
        System.out.println("Description: " + sugarMilkCoffee.getDescription());
        System.out.println("Price: " + sugarMilkCoffee.getCost());
    }
}
