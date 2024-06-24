package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@NoRepositoryBean
@Repository
public interface CRUDRepository<T, ID> extends JpaRepository<T, ID> {
}
