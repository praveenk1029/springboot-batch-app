package com.practice.springbootbatchapp.batch;

import com.practice.springbootbatchapp.model.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductProcessor implements ItemProcessor<Product, Product> {

    private static final Map<String, String> PRODUCT_TYPES=new HashMap<>();

    public ProductProcessor() {
        PRODUCT_TYPES.put("001","Car");
        PRODUCT_TYPES.put("002","Bus");
        PRODUCT_TYPES.put("003","Sports Car");
        PRODUCT_TYPES.put("004","Van");
        PRODUCT_TYPES.put("005","Truck");
        PRODUCT_TYPES.put("006","RV");
    }

    @Override
    public Product process(Product product) throws Exception {

        String type = product.getProductType();
        String productType = PRODUCT_TYPES.get(type);
        product.setProductType(productType);
        product.setCreatedDate(new Date());
        return product;
    }
}
