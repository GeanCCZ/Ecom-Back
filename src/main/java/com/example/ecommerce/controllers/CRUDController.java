package com.example.ecommerce.controllers;

import com.example.ecommerce.service.CRUDService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping()
public abstract class CRUDController <T, ID, DTO> {

    private static final String ID_PATH_VARIABLE = "/{id}";

    private final CRUDService<T, ID, DTO> service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public DTO create(@RequestBody @Valid DTO dto) {
        return service.create(dto);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<T> getAll() {
        return service.findAll();
    }

    @GetMapping(ID_PATH_VARIABLE)
    @ResponseStatus(value = HttpStatus.OK)
    public T getById(@PathVariable ID id) {
        return service.findById(id);
    }

    @PutMapping(ID_PATH_VARIABLE)
    @ResponseStatus(value = HttpStatus.OK)
    public DTO update(@PathVariable ID id, @RequestBody @Valid DTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(ID_PATH_VARIABLE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }

}
