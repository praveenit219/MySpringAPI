package com.pheonix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pheonix.domain.Product;
import com.pheonix.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	@Override
	public Iterable<Product> listAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		
		return productRepository.findOne(id);
	}

	@Override
	public Product saveProduct(Product product) {
		if(null==product.getProductId()) {
			product.setProductId(java.util.UUID.randomUUID().toString());
		}
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.delete(id);
		
	}

}
