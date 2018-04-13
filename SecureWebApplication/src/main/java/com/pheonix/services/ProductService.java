package com.pheonix.services;

import com.pheonix.domain.Product;

public interface ProductService {
	Iterable<Product> listAllProducts();

	Product getProductById(Integer id);

	Product saveProduct(Product product);

	void deleteProduct(Integer id);

}
