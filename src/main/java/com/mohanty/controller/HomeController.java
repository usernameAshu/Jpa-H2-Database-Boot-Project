package com.mohanty.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohanty.model.Customer;
import com.mohanty.repository.CustomRepository;

@RequestMapping(value="/app")
@RestController
public class HomeController {

	@Autowired
	CustomRepository repo;
	
	@PostConstruct
	public void loadData() {
		
		Customer cust1 = new Customer();
		Customer cust2 = new Customer();
		cust1.setCust_name("Niladri");cust1.setCust_address("Bangalore");
		repo.save(cust1);
		cust2.setCust_name("Ashutosh");cust2.setCust_address("Delhi");
		repo.save(cust2);
		
	}
	
	@GetMapping(value = "/secured/getAllCustomers")
	public List<Customer> getAllCustomers() {
		
		List<Customer> cust_list = repo.findAll();
		return cust_list;
	}
	
	@GetMapping(value = "/secured/getCustomerById/{cust_id}")
	public Customer getCustomerById(@PathVariable int cust_id) {
		Optional<Customer> cust_list = repo.findById(cust_id);
		Customer customer =null;

		if(cust_list.isPresent())
			customer = cust_list.get();
		else
			throw new RuntimeException("Customer ID not Found:"+cust_id);
		
		return customer;
	}
	
	
}
