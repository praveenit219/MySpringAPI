package com.pheonix.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pheonix.domain.Product;

public interface ProductRepository  extends CrudRepository<Product, Integer>{
}