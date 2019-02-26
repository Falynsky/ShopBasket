class Product {

    private String productName;
    private double price;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    String getName() {  return productName; }

    double getPrice() {
        return price;
    }
}
