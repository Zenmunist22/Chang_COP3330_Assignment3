package ex44;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class AppTest extends TestCase {

    public void testFindProduct() {
        Product p = new Product("Jello", 25.00, 5);
        Products ps = new Products(new ArrayList<Product>());
        ps.getProducts().add(p);
        Assertions.assertEquals(25.00, App.findProduct(ps, "Jello").getPrice());
    }
}