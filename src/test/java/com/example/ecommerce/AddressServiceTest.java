package com.example.ecommerce;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.AddressDTO;
import com.example.ecommerce.domain.entities.Address;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.AddressRepository;
import com.example.ecommerce.service.AddressService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private CRUDRepository<Address, UUID> repository;

    @Mock
    private Adapter<Address, AddressDTO> addressAdapter;

    @Test
    public void testCreateAddress() {
        AddressDTO addressDTO = new AddressDTO(null, "Rua Luiz Gonzaga", "785", "87111111", "Chique Chique", "BA", "Brasil", "", "Tanguistedes", null, null);
        Address newAddress = new Address();

        newAddress.setStreet(addressDTO.street());
        newAddress.setNumber(addressDTO.number());
        newAddress.setCep(addressDTO.cep());
        newAddress.setCity(addressDTO.city());
        newAddress.setState(addressDTO.state());
        newAddress.setCountry(addressDTO.country());
        newAddress.setComplement(addressDTO.complement());
        newAddress.setNeighborhood(addressDTO.neighborhood());
        newAddress.setSupplier(addressDTO.supplier());
        newAddress.setUser(addressDTO.user());

        when(this.addressAdapter.fromDto(any(AddressDTO.class))).thenReturn(newAddress);

        when(this.repository.save(any(Address.class))).thenReturn(newAddress);

        this.addressService.create(addressDTO);

        verify(this.repository).save(newAddress);
        verify(this.addressAdapter).fromEntity(newAddress);

        assertEquals(addressDTO.street(), newAddress.getStreet());
        assertEquals(addressDTO.number(), newAddress.getNumber());
        assertEquals(addressDTO.cep(), newAddress.getCep());
        assertEquals(addressDTO.city(), newAddress.getCity());
        assertEquals(addressDTO.state(), newAddress.getState());
        assertEquals(addressDTO.country(), newAddress.getCountry());
        assertEquals(addressDTO.complement(), newAddress.getComplement());
        assertEquals(addressDTO.neighborhood(), newAddress.getNeighborhood());
        assertEquals(addressDTO.supplier(), newAddress.getSupplier());
        assertEquals(addressDTO.user(), newAddress.getUser());

    }

    @Test
    public void testUpdateAddress() {

        AddressDTO addressDTO = new AddressDTO(null, "Rua Luiz Gonzaga", "785", "87111111", "Chique Chique", "BA", "Brasil", "", "Tanguistedes", null, null);
        Address newAddress = new Address();

        newAddress.setStreet(addressDTO.street());
        newAddress.setNumber(addressDTO.number());
        newAddress.setCep(addressDTO.cep());
        newAddress.setCity(addressDTO.city());
        newAddress.setState(addressDTO.state());
        newAddress.setCountry(addressDTO.country());
        newAddress.setComplement(addressDTO.complement());
        newAddress.setNeighborhood(addressDTO.neighborhood());
        newAddress.setSupplier(addressDTO.supplier());
        newAddress.setUser(addressDTO.user());

        when(this.addressAdapter.fromDto(any(AddressDTO.class))).thenReturn(newAddress);

        when(this.repository.save(any(Address.class))).thenReturn(newAddress);

        this.addressService.create(addressDTO);

        verify(this.repository).save(newAddress);
        verify(this.addressAdapter).fromEntity(newAddress);



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
