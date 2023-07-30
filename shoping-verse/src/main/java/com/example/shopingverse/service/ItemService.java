package com.example.shopingverse.service;

import com.example.shopingverse.dto.RequestDto.ItemRequestDto;
import com.example.shopingverse.exception.CustomerNotFoundException;
import com.example.shopingverse.exception.InsufficientQuantityException;
import com.example.shopingverse.exception.ProductNotFoundException;
import com.example.shopingverse.model.Customer;
import com.example.shopingverse.model.Item;
import com.example.shopingverse.model.Product;
import com.example.shopingverse.repository.CustomerRepository;
import com.example.shopingverse.repository.ProductRepository;
import com.example.shopingverse.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    public Item createItem(ItemRequestDto itemRequestDto) {
        Customer customer=customerRepository.findByEmailId(itemRequestDto.getCustomerEmail());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesnt exist");
        }
        Optional<Product> optionalproduct=productRepository.findById(itemRequestDto.getProductId());
        if(optionalproduct.isEmpty()){
            throw new ProductNotFoundException("product doesnot exist");
        }
        Product product=optionalproduct.get();
        // check for available quantity
        if(product.getAvailableQuantity()< itemRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! required quantity is not available");
        }
        Item item= ItemTransformer.ItemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
        item.setProduct(product);
        return item;


    }
}
