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

        AddressDTO createdAddress = addressService.create(newAddress);

        AddressDTO expectedAddress = new AddressDTO(createdAddress.id(), newAddress.street(), newAddress.number(), newAddress.cep(), newAddress.city(), newAddress.state(), newAddress.country(), newAddress.complement(), newAddress.neighborhood(), newAddress.supplier(), newAddress.user());

        assertEquals(expectedAddress, createdAddress);
    }

    @Test
    public void testUpdateAddress() {

        AddressDTO newAddress = new AddressDTO(null, "Rua Luiz Gonzaga", "785", "87111111", "Chique Chique", "BA", "Brasil", "", "Tanguistedes", null, null);

        AddressDTO createdAddress = addressService.create(newAddress);

        AddressDTO updateAddressDTO = new AddressDTO(null, "Rua Pereira de Andrade", "1321", "00000001", "Formiga", "MG", "Brasil", "", "Tanguistedes", null, null);

        this.addressService.update(newAddress.id(), updateAddressDTO);

        AddressDTO expectedAddress = new AddressDTO(updateAddressDTO.id(), updateAddressDTO.street(), updateAddressDTO.number(), updateAddressDTO.cep(), updateAddressDTO.city(), updateAddressDTO.state(), updateAddressDTO.country(), updateAddressDTO.complement(), updateAddressDTO.neighborhood(), updateAddressDTO.supplier(), updateAddressDTO.user());

        assertEquals(expectedAddress, createdAddress);
    }

}
