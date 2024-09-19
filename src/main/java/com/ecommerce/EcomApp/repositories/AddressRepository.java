package com.ecommerce.EcomApp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.EcomApp.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}