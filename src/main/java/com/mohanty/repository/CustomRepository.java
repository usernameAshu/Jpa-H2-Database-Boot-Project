package com.mohanty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohanty.model.Customer;

public interface CustomRepository extends JpaRepository<Customer, Integer> {

}
