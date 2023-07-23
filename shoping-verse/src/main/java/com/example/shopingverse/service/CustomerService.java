package com.example.shopingverse.service;

import com.example.shopingverse.dto.RequestDto.CustomerRequestDto;
import com.example.shopingverse.dto.ResponseDto.CustomerResponseDto;
import com.example.shopingverse.model.Cart;
import com.example.shopingverse.model.Customer;
import com.example.shopingverse.repository.CustomerRepository;
import com.example.shopingverse.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
        // dtp->entity
//        Customer customer=new Customer();
//        customer.setName(customerRequestDto.getName());
//        customer.setGender(customerRequestDto.getGender());
//        customer.setEmailId(customerRequestDto.getEmailId());
//        customer.setMobNo(customerRequestDto.getMobNo());
        // dtp->entity
        Customer customer= CustomerTransformer.customerRequestDtoTocustomer(customerRequestDto);

        Cart cart=new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        customer.setCart(cart);

       Customer savedCustomer= customerRepository.save(customer);
       // prepare the response dto

        CustomerResponseDto customerResponseDto=CustomerTransformer.customerToCustomerResponseDto(savedCustomer);
        return customerResponseDto;
    }
}
