import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShopBasketTest {

    ShopBasket  sb = new ShopBasket();
    Product apple = new Product("Apple",4.0);

    @Test
    void doesProductExist() {
        sb.addProduct(apple,5);
        assertTrue(sb.doesProductExist(sb.getBasketCase(),apple));
    }
}