import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopBasketTest {

    private ShopBasket sb = new ShopBasket();
    private Product apple = new Product("Apple", 4.0);
    private Product tomato = new Product("Tomatoe", 3.2);

    @Test
    void doesProductExist() {
        sb.addProduct(apple, 5);
        assertTrue(sb.doesProductExist(sb.getBasketCase(), apple));
    }

    @Test
    void removeProductFromBasket() {
        sb.addProduct(apple, 2);
        sb.removeProduct(apple, 2);
        assertFalse(sb.doesProductExist(sb.getBasketCase(), apple));
    }

    @Test
    void totalCost() {
        sb.addProduct(apple, 2);
        sb.addProduct(tomato, 6);
        assertEquals(apple.getPrice() * sb.getBasketCase().get(apple) + tomato.getPrice() * sb.getBasketCase().get(tomato), sb.coutTotalCost());
    }

}