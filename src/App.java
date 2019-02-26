import java.text.DecimalFormat;
import java.util.NoSuchElementException;

public class App {

    private static DecimalFormat df2 = new DecimalFormat("#.00");

    public static void main(String[] args) {
        try {
            Product apple = new Product("Apple", 2);
            Product milkCartonBox = new Product("Milk Carton Box", 3.45);
            Product bread = new Product("Bread", 2.78);

            ShopBasket myBasket = new ShopBasket();
            myBasket.addProduct(apple, 2);
            myBasket.addProduct(milkCartonBox, 2);
            myBasket.addProduct(milkCartonBox, 3);
            myBasket.addProduct(bread, 1);
            myBasket.addProduct(bread, 1);

            System.out.println("\nYour basket:");
            myBasket.showBasketContents();

            System.out.println("\nYour basket with the price:\n");
            myBasket.showBasketContentsWithAmount();

            System.out.println("\nTotal cost: " + df2.format(myBasket.coutTotalCost()) + " pln");

            myBasket.removeProduct(apple, 1);
            try {
                myBasket.removeProduct(milkCartonBox, 4);
            } catch (NoSuchElementException ex) {
                ex.getMessage();
            }

            System.out.println("\nYour basket with the price after after removal some objects:\n");
            myBasket.showBasketContentsWithAmount();

            System.out.println("\nTotal cost: " + df2.format(myBasket.coutTotalCost()) + " pln");
        } catch (NullPointerException | IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
