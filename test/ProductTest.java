import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductTest {

    Product apple;

    @BeforeEach
    void startUp() {
        apple = new Product("Apple", 4.0);
    }

    @Test
    void getName() {
        assertEquals("Apple", apple.getName());
    }

    @Test
    void getPrice() {
        assertEquals(4.0, apple.getPrice());
    }

    @Test
    void productObjectIsNotNull() {
        assertNotNull(apple);
    }
}