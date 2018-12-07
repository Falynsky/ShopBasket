public class Program {

    public static void main(String[] args) {

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

        myBasket.removeProduct(apple,1);
        myBasket.removeProduct(milkCartonBox, 4);

        System.out.println("\nYour basket with the price after after removal some objects:\n");
        myBasket.showBasketContentsWithAmount();



    }
}
