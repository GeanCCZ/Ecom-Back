package com.example.ecommerce;

import com.example.ecommerce.domain.dto.AddressDTO;
import com.example.ecommerce.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AddressServiceTest {

    private AddressService addressService;

    @Test
    public void testCreateAddress() {
        AddressDTO newAddress = new AddressDTO(null, "Rua Luiz Gonzaga", "785", "87111111", "Chique Chique", "BA", "Brasil", "", "Tanguistedes", null, null);

        AddressDTO createdAddress = this.addressService.create(newAddress);

        assertEquals(newAddress.street(), createdAddress.street());
        assertEquals(newAddress.number(), createdAddress.number());
        assertEquals(newAddress.cep(), createdAddress.cep());
        assertEquals(newAddress.city(), createdAddress.city());
        assertEquals(newAddress.state(), createdAddress.state());
        assertEquals(newAddress.country(), createdAddress.country());
        assertEquals(newAddress.complement(), createdAddress.complement());
        assertEquals(newAddress.neighborhood(), createdAddress.neighborhood());
        assertEquals(newAddress.supplier(), createdAddress.supplier());
        assertEquals(newAddress.user(), createdAddress.user());
    }

    @Test
    public void testUpdateAddress() {

        AddressDTO newAddress = new AddressDTO(null, "Rua Luiz Gonzaga", "785", "87111111", "Chique Chique", "BA", "Brasil", "", "Tanguistedes", null, null);

        this.addressService.create(newAddress);

        AddressDTO updatedAddressDTO = new AddressDTO(null, "Rua Pereira de Andrade", "1321", "00000001", "Formiga", "MG", "Brasil", "", "Tanguistedes", null, null);

        AddressDTO updatedAddress = this.addressService.update(newAddress.id(), updatedAddressDTO);


        assertEquals(newAddress.street(), updatedAddress.street());
        assertEquals(newAddress.number(), updatedAddress.number());
        assertEquals(newAddress.cep(), updatedAddress.cep());
        assertEquals(newAddress.city(), updatedAddress.city());
        assertEquals(newAddress.state(), updatedAddress.state());
        assertEquals(newAddress.country(), updatedAddress.country());
        assertEquals(newAddress.complement(), updatedAddress.complement());
        assertEquals(newAddress.neighborhood(), updatedAddress.neighborhood());
        assertEquals(newAddress.supplier(), updatedAddress.supplier());
        assertEquals(newAddress.user(), updatedAddress.user());
    }

}
