package com.practice.springbootbatchapp.batch;

import com.practice.springbootbatchapp.model.Product;
import com.practice.springbootbatchapp.repository.ProductRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDBWriter implements ItemWriter<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void write(List<? extends Product> products) throws Exception {
        productRepository.saveAll(products);
    }
}
