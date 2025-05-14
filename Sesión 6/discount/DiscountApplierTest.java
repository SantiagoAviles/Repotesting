package tudelft.discount;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DiscountApplierTest {

    @Test
    public void applyDiscountsCorrectly() {
        // Arrange
        Product homeProduct = new Product("Vacuum", 100.0, "HOME"); // Debe quedar en 90.0
        Product businessProduct = new Product("Printer", 200.0, "BUSINESS"); // Debe quedar en 220.0
        List<Product> products = Arrays.asList(homeProduct, businessProduct);

        ProductDao mockDao = mock(ProductDao.class);
        when(mockDao.all()).thenReturn(products);

        DiscountApplier applier = new DiscountApplier(mockDao);

        // Act
        applier.setNewPrices();

        // Assert
        assertEquals(90.0, homeProduct.getPrice(), 0.01);
        assertEquals(220.0, businessProduct.getPrice(), 0.01);
    }
}
