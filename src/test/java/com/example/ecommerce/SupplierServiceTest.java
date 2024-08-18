import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SupplierServiceTest {

    @InjectMocks
    private SupplierService supplierService;

    @Test
    public void testSupplierCreate(){
        SupplierDTO newSupplier = new SupplierDTO(null, "Transistors Unlimited", "Transistors Unlimited LTDA", "We made transistors", "11110001/1",null, null,null);

        SupplierDTO createdSupplier = this.supplierService.create(newSupplier);

        assertEquals(newSupplier.tradeName(), createdSupplier.tradeName());
        assertEquals(newSupplier.legalName(), createdSupplier.legalName());
        assertEquals(newSupplier.description(), createdSupplier.description());
        assertEquals(newSupplier.cnpj(), createdSupplier.cnpj());

        assertEquals(newSupplier.stockList(), createdSupplier.stockList());
        assertEquals(newSupplier.productList(), createdSupplier.productList());
        assertEquals(newSupplier.addressList(), createdSupplier.addressList());

    }
}
