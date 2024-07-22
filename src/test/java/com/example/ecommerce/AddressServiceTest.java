package com.example.ecommerce;

import com.example.ecommerce.domain.dto.AddressDTO;
import com.example.ecommerce.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AddressServiceTest {

    @Autowired
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

        assertEquals(updatedAddressDTO.street(), updatedAddress.street());
        assertEquals(updatedAddressDTO.number(), updatedAddress.number());
        assertEquals(updatedAddressDTO.cep(), updatedAddress.cep());
        assertEquals(updatedAddressDTO.city(), updatedAddress.city());
        assertEquals(updatedAddressDTO.state(), updatedAddress.state());
        assertEquals(updatedAddressDTO.country(), updatedAddress.country());
        assertEquals(updatedAddressDTO.complement(), updatedAddress.complement());
        assertEquals(updatedAddressDTO.neighborhood(), updatedAddress.neighborhood());
        assertEquals(updatedAddressDTO.supplier(), updatedAddress.supplier());
        assertEquals(updatedAddressDTO.user(), updatedAddress.user());

    }

}
