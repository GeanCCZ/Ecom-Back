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
        AddressDTO addressDTO = new AddressDTO(UUID.randomUUID(), "Rua Luiz Gonzaga", "785", "87111111", "Chique Chique", "BA", "Brasil", "", "Tanguistedes", null, null);
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

        AddressDTO addressDTO = new AddressDTO(UUID.randomUUID(), "Rua Luiz Gonzaga", "785", "87111111", "Chique Chique", "BA", "Brasil", "", "Tanguistedes", null, null);
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

        AddressDTO createdAddress = this.addressService.create(addressDTO);

        verify(this.repository).save(newAddress);
        verify(this.addressAdapter).fromEntity(newAddress);

        AddressDTO updatedAddressDTO = new AddressDTO(createdAddress.id(), "Rua Petruquio Japolino", "111", "66666666", "Formiga", "MG", "Brasil", "", "Pelourinho", null, null);
        Address updatedAddress = new Address();

        updatedAddress.setStreet(updatedAddressDTO.street());
        updatedAddress.setNumber(updatedAddressDTO.number());
        updatedAddress.setCep(updatedAddressDTO.cep());
        updatedAddress.setCity(updatedAddressDTO.city());
        updatedAddress.setState(updatedAddressDTO.state());
        updatedAddress.setCountry(updatedAddressDTO.country());
        updatedAddress.setComplement(updatedAddressDTO.complement());
        updatedAddress.setNeighborhood(updatedAddressDTO.neighborhood());
        updatedAddress.setSupplier(updatedAddressDTO.supplier());
        updatedAddress.setUser(updatedAddressDTO.user());

        when(this.addressAdapter.fromDto(any(AddressDTO.class))).thenReturn(updatedAddress);

        when(this.addressService.update(createdAddress.id(), updatedAddressDTO)).thenReturn(this.addressAdapter.fromEntity(updatedAddress));


        addressService.update(createdAddress.id(), updatedAddressDTO);

        assertEquals(updatedAddressDTO.street(), updatedAddress.getStreet());
        assertEquals(updatedAddressDTO.number(), updatedAddress.getNumber());
        assertEquals(updatedAddressDTO.cep(), updatedAddress.getCep());
        assertEquals(updatedAddressDTO.city(), updatedAddress.getCity());
        assertEquals(updatedAddressDTO.state(), updatedAddress.getState());
        assertEquals(updatedAddressDTO.country(), updatedAddress.getCountry());
        assertEquals(updatedAddressDTO.complement(), updatedAddress.getComplement());
        assertEquals(updatedAddressDTO.neighborhood(), updatedAddress.getNeighborhood());
        assertEquals(updatedAddressDTO.supplier(), updatedAddress.getSupplier());
        assertEquals(updatedAddressDTO.user(), updatedAddress.getUser());

    }

}
