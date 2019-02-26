import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ShopBasket {

    private Map<Product, Integer> basketCase = new HashMap<>();
    private static DecimalFormat df2 = new DecimalFormat("#.00");

    void addProduct(Product product, int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative!");
        if (!doesProductExist(basketCase, product)) {
            basketCase.put(product, quantity);
        } else {
            int increasedQuantity = basketCase.get(product) + quantity;
            basketCase.put(product, increasedQuantity);
        }
    }

    boolean doesProductExist(Map<Product, Integer> basket, Product product) {
        return basket.containsKey(product);
    }

    void showBasketContentsWithAmount() {
        for (Map.Entry<Product, Integer> p : basketCase.entrySet()) {
            System.out.println(p.getKey().getName() + "\t" + df2.format(p.getKey().getPrice()) + " pln\tQuantity: " + p.getValue());
        }
    }

    Map<Product, Integer> getBasketCase() {
        return basketCase;
    }

    double coutTotalCost() {
        double totalCost = 0;
        for (Map.Entry<Product, Integer> p : basketCase.entrySet()) {
            totalCost += p.getKey().getPrice() * p.getValue();
        }
        return totalCost;
    }

    void showBasketContents() {
        for (Map.Entry<Product, Integer> p : basketCase.entrySet()) {
            System.out.println(p.getKey().getName() + "\t Quantity: " + p.getValue());
        }
    }

    void removeProduct(Product product, int quantity) throws NoSuchElementException {
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

    }
}


