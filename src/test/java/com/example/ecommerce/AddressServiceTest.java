package com.example.ecommerce;

import com.example.ecommerce.adapters.AddressAdapter;
import com.example.ecommerce.domain.dto.AddressDTO;
import com.example.ecommerce.domain.entities.Address;
import com.example.ecommerce.repository.custom.AddressRepository;
import com.example.ecommerce.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class AddressServiceTest {

    @Mock
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private AddressAdapter addressAdapter;

    @BeforeEach
    void setUp() {
        addressRepository = mock(AddressRepository.class);
        addressAdapter = new AddressAdapter();
        addressService = new AddressService(addressRepository, addressAdapter, addressRepository);
    }

    @Test
    void createAddressSuccessfully() {
        AddressDTO addressDTO = new AddressDTO(UUID.randomUUID(), "Street", "Number", "CEP", "City", "State", "Country", "Complement", "Neighborhood", null, null);
        Address address = new Address(addressDTO.street(), addressDTO.number(), addressDTO.cep(), addressDTO.city(), addressDTO.state(), addressDTO.country(), addressDTO.complement(), addressDTO.neighborhood(), addressDTO.supplier(), addressDTO.user());

        when(addressRepository.save(any(Address.class))).thenReturn(address);
        when(addressRepository.findById(any())).thenReturn(Optional.of(address));

        AddressDTO createdAddress = addressService.create(addressDTO);

        assertEquals("Street", createdAddress.street());
    }

    @Test
    void createAddressAlreadyExists() {
        AddressDTO addressDTO = new AddressDTO(UUID.randomUUID(), "Street", "Number", "CEP", "City", "State", "Country", "Complement", "Neighborhood", null, null);

        assertThrows(RuntimeException.class, () -> addressService.create(addressDTO));

    }

    @Test
    void updateAddressSuccessfully() {
        UUID id = UUID.randomUUID();
        AddressDTO addressDTO = new AddressDTO(id, "Street", "Number", "CEP", "City", "State", "Country", "Complement", "Neighborhood", null, null);
        Address address = new Address(addressDTO.street(), addressDTO.number(), addressDTO.cep(), addressDTO.city(), addressDTO.state(), addressDTO.country(), addressDTO.complement(), addressDTO.neighborhood(), addressDTO.supplier(), addressDTO.user());

        when(addressRepository.findById(id)).thenReturn(Optional.of(address));
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        AddressDTO updatedAddress = addressService.update(id, addressDTO);

        verify(addressRepository).save(any(Address.class));
        verify(addressRepository, times(2)).findById(id);

        assertEquals("Street", updatedAddress.street());
    }

    @Test
    void updateAddressNotFound() {
        UUID id = UUID.randomUUID();
        AddressDTO addressDTO = new AddressDTO(id, "Street", "Number", "CEP", "City", "State", "Country", "Complement", "Neighborhood", null, null);

        when(addressRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> addressService.update(id, addressDTO));
    }

    @Test
    void deleteAdressSuccessfully() {
        UUID id = UUID.randomUUID();
        AddressDTO addressDTO = new AddressDTO(id, "Street", "Number", "CEP", "City", "State", "Country", "Complement", "Neighborhood", null, null);
        Address address = new Address(addressDTO.street(), addressDTO.number(), addressDTO.cep(), addressDTO.city(), addressDTO.state(), addressDTO.country(), addressDTO.complement(), addressDTO.neighborhood(), addressDTO.supplier(), addressDTO.user());

        when(addressRepository.findById(id)).thenReturn(Optional.of(address));

        addressService.delete(id);

    }

}
