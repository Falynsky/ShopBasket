import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShopBasket {

    private Map<Product, Integer> basketCase = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative!");
        if (!doesProductExist(basketCase, product)) {
            basketCase.put(product, quantity);
        } else {
            int increasedQuantity = basketCase.get(product).intValue()+ quantity;
            basketCase.put(product, increasedQuantity);
        }
    }


    public boolean doesProductExist(Map<Product, Integer> basket, Product product) {
        if (basket.containsKey(product)) return true;
        else return false;
    }

    public void showBasketContentsWithAmount() {
        double totalCost = 0;
        for (Map.Entry<Product, Integer> p : basketCase.entrySet()) {
            System.out.println(p.getKey().getName() + "\t" + p.getKey().getPrice() + " pln\tQuantity: " + p.getValue());
        }
    }

    public double coutTotalCost() {
        double totalCost = 0;
        for (Map.Entry<Product, Integer> p : basketCase.entrySet()) {
            totalCost += p.getKey().getPrice() * p.getValue();
        }
        return totalCost;
    }

    public void showBasketContents() {
        for (Map.Entry<Product, Integer> p : basketCase.entrySet()) {
            System.out.println(p.getKey().getName() + "\t Quantity: " + p.getValue());
        }
    }

    public void removeProduct(Product product, int quantity) {
        if (!basketCase.isEmpty()) {
            if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative!");
            if (!doesProductExist(basketCase, product)) {
                System.out.println("There's no product like that");
            } else {
                if (basketCase.get(product) < quantity) {
                    throw new IllegalArgumentException("Quantity cannot be greater than inside the basket!");
                } else if (basketCase.get(product) > quantity) {
                    int decreasedQuantity = basketCase.get(product) - quantity;
                    basketCase.replace(product, decreasedQuantity);
                } else {
                    basketCase.remove(product, quantity);
                }
            }
        } else {
            System.out.println("Your basket is empity!");
        }
    }
}


