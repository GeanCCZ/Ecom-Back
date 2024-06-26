package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.StockDTO;
import com.example.ecommerce.domain.entities.Stock;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("stock")
public class StockController extends CRUDController<Stock, UUID, StockDTO> {

    public StockController(CRUDService<Stock,UUID,StockDTO> service){
        super(service);
    }

}
