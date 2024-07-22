package com.example.ecommerce;

import com.example.ecommerce.domain.dto.StockDTO;
import com.example.ecommerce.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StockServiceTest {

    @Autowired
    private StockService stockService;

    @Test
    public void testStockCreate(){

        StockDTO newStock = new StockDTO(null, 1, null, null);

        StockDTO createdStock = this.stockService.create(newStock);

        assertEquals(newStock.product(), createdStock.product());
        assertEquals(newStock.quantity(), createdStock.quantity());
        assertEquals(newStock.supplier(), createdStock.supplier());

    }

    @Test
    public void testStockUpdate(){

        StockDTO newStock = new StockDTO(null, 1, null, null);

        StockDTO createdStock = this.stockService.create(newStock);

        StockDTO updateStockDTO = new StockDTO(createdStock.id(), 3, null, null);

        StockDTO updatedStock = this.stockService.update(createdStock.id(),updateStockDTO);

        assertEquals(updateStockDTO.product(), updatedStock.product());
        assertEquals(updateStockDTO.quantity(), updatedStock.quantity());
        assertEquals(updateStockDTO.supplier(), updatedStock.supplier());

    }

}
